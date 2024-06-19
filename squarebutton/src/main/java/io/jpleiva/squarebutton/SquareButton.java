package io.jpleiva.squarebutton;

import static io.jpleiva.squarebutton.R.*;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

public class SquareButton extends CardView {
    public SquareButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inflate(context, layout.square_button, this);

        CardView cvRoot = findViewById(R.id.cvRoot);
        TextView tvText = findViewById(R.id.tvText);

        try {
            TypedArray attributeSet = context.obtainStyledAttributes(attrs, R.styleable.SquareButton);

            if (attributeSet.getString(styleable.SquareButton_bgColor) != null) {
                cvRoot.getBackground().setTint(Color.parseColor(attributeSet.getString(R.styleable.SquareButton_bgColor)));
            }
            if (attributeSet.getFloat(R.styleable.SquareButton_radius, 8f) != 0f) {
                cvRoot.setRadius(attributeSet.getFloat(R.styleable.SquareButton_radius, 8f));
            }
            if (attributeSet.getString(R.styleable.SquareButton_text) != null) {
                tvText.setText(attributeSet.getString(R.styleable.SquareButton_text));
            }
            if (attributeSet.getString(styleable.SquareButton_textColor) != null) {
                tvText.setTextColor(Color.parseColor(attributeSet.getString(R.styleable.SquareButton_textColor)));
            }
            if (attributeSet.getInt(R.styleable.SquareButton_fontWeight, 700) != 0) {
                tvText.setTypeface(Typeface.create(null, attributeSet.getInt(R.styleable.SquareButton_fontWeight, 700), false));
            }
            if (attributeSet.getFloat(R.styleable.SquareButton_fontSize, 12f) != 0f) {
                tvText.setTextSize(attributeSet.getFloat(R.styleable.SquareButton_fontSize, 12f));
            }
        } catch (Exception e){
            Log.e("SquareButton", e.getMessage(), e);
        }
    }
}
