package info.techienotes.customlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Bharat Kul Ratan
 */
public class CustomLayout extends ViewGroup {

    public CustomLayout(Context context) {
        super(context);
    }

    // This constructor is needed for inflating from XML
    public CustomLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * onLayout() method is mandatory to override
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        /**
         * (left,top) is left most corner of rectangular child and
         * (right,bottom) is right most corner
         */
        int itemHeight = (bottom - top)/getChildCount();

        // itemHeight is height of a single child

        for(int i=0; i < this.getChildCount(); i++){
            View v = getChildAt(i);

            //adding child views horizontally
            // first(left) and third(right) parameter will remain same
            // second(top) and fourth(bottom) parameter will depend on i
            v.layout(0, itemHeight * i, right, itemHeight*(i+1));
        }
    }

    /**
     * onMeasure() is called in first phase where child views are measured
     * @param widthMeasureSpec Horizontal space requirements as imposed by the parent
     * @param heightMeasureSpec Vertical space requirements as imposed by the parent
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int viewsInLayout = getChildCount();
        
        int widthSpec = MeasureSpec.makeMeasureSpec(
                getMeasuredWidth(), MeasureSpec.EXACTLY);
        int heightSpec = MeasureSpec.makeMeasureSpec(
                getMeasuredHeight()/viewsInLayout, MeasureSpec.EXACTLY);

        for(int i=0; i<viewsInLayout; i++){
            View v = getChildAt(i);
            /**
             * measure() is called to find out how big a view should be.
             * The parent supplies constraint information in the width and height parameters.
             */
            v.measure(widthSpec, heightSpec);
        }
    }
}
