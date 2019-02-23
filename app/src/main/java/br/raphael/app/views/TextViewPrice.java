package br.raphael.app.views;

import android.content.Context;
import android.util.AttributeSet;

public class TextViewPrice extends android.support.v7.widget.AppCompatTextView {

    public TextViewPrice(Context context) {
        super(context);
    }

    public TextViewPrice(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TextViewPrice(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setText(float value) {
        setText("R$ "+value);
    }
}
