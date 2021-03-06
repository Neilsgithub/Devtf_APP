package com.devtf_l.app.views;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.devtf_l.app.R;

/**
 * @desc 自定义字体的TextView
 * @author ljh lijunhuayc@sina.com 2015-4-26
 */
public class FontsTextView extends TextView {
	static Map<String, Typeface> fontMap = new HashMap<String, Typeface>();//字体资源缓存
	
	public FontsTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(attrs);
	}

	public FontsTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(attrs);
	}

	public FontsTextView(Context context) {
		super(context);
		init(null);
	}

	private void init(final AttributeSet attrs) {
		if (attrs != null) {
			TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.FontsName);
			String fontName = a.getString(R.styleable.FontsName_fontName);
			if (fontName != null) {
				Typeface myTypeface = fontMap.get(fontName);
				if(null == myTypeface){
					myTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/" + fontName);
					fontMap.put(fontName, myTypeface);
				}
				setTypeface(myTypeface);
			}
			a.recycle();
		}
	}
}