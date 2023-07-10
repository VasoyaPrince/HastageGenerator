package wimble.hashtag.hashtagram;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class SlidingTabLayout extends HorizontalScrollView implements ViewPager.OnPageChangeListener {
    private static final int STYLE_BLOCK = 2;
    private static final int STYLE_NORMAL = 0;
    private static final int STYLE_TRIANGLE = 1;
    private Context mContext;
    private float mCurrentPositionOffset;
    private int mCurrentTab;
    private int mDividerColor;
    private float mDividerPadding;
    private Paint mDividerPaint;
    private float mDividerWidth;
    private int mHeight;
    private int mIconGravity;
    private float mIconHeight;
    private float mIconMargin;
    private boolean mIconVisible;
    private float mIconWidth;
    private int mIndicatorColor;
    private float mIndicatorCornerRadius;
    private GradientDrawable mIndicatorDrawable;
    private int mIndicatorGravity;
    private float mIndicatorHeight;
    private float mIndicatorMarginBottom;
    private float mIndicatorMarginLeft;
    private float mIndicatorMarginRight;
    private float mIndicatorMarginTop;
    private Rect mIndicatorRect;
    private int mIndicatorStyle;
    private float mIndicatorWidth;
    private boolean mIndicatorWidthEqualTitle;
    private SparseArray<Boolean> mInitSetMap;
    private int mLastScrollX;
    public OnTabSelectListener mListener;
    private Paint mRectPaint;
    private int mTabCount;
    private ArrayList<CustomTabEntity> mTabEntitys;
    private float mTabPadding;
    private Rect mTabRect;
    private boolean mTabSpaceEqual;
    private float mTabWidth;
    private LinearLayout mTabsContainer;
    private boolean mTextAllCaps;
    private int mTextBold;
    private Paint mTextPaint;
    private int mTextSelectColor;
    private int mTextUnselectColor;
    private float mTextsize;
    private String[] mTitles;
    private Paint mTrianglePaint;
    private Path mTrianglePath;
    private int mUnderlineColor;
    private int mUnderlineGravity;
    private float mUnderlineHeight;
    public ViewPager mViewPager;
    private float margin;
    private static final int TEXT_BOLD_NONE = 0;

    public interface CustomTabProvider {
        View getCustomTabView(ViewGroup viewGroup, int i);

        void tabSelect(View view);

        void tabUnselect(View view);
    }

    public void onPageScrollStateChanged(int i) {
    }

    public SlidingTabLayout(Context context) {
        this(context, null, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIndicatorRect = new Rect();
        this.mTabRect = new Rect();
        this.mIndicatorDrawable = new GradientDrawable();
        this.mRectPaint = new Paint(1);
        this.mDividerPaint = new Paint(1);
        this.mTrianglePaint = new Paint(1);
        this.mTrianglePath = new Path();
        this.mIndicatorStyle = 0;
        this.mTabEntitys = new ArrayList<>();
        this.mTextPaint = new Paint(1);
        this.mInitSetMap = new SparseArray<>();
        setFillViewport(true);
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.mContext = context;
        this.mTabsContainer = new LinearLayout(context);
        addView(this.mTabsContainer);
        obtainAttributes(context, attributeSet);
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (!attributeValue.equals("-1") && !attributeValue.equals("-2")) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842997});
            this.mHeight = obtainStyledAttributes.getDimensionPixelSize(0, -2);
            obtainStyledAttributes.recycle();
        }
    }

    private void obtainAttributes(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SlidingTabLayout);

        mIndicatorStyle = ta.getInt(R.styleable.SlidingTabLayout_tl_indicator_style, STYLE_NORMAL);
        mIndicatorColor = ta.getColor(R.styleable.SlidingTabLayout_tl_indicator_color, Color.parseColor(mIndicatorStyle == STYLE_BLOCK ? "#0B141B" : "#0B141B"));
        mIndicatorHeight = ta.getDimension(R.styleable.SlidingTabLayout_tl_indicator_height, dp2px(mIndicatorStyle == STYLE_TRIANGLE ? 1 : (mIndicatorStyle == STYLE_BLOCK ? 0 : 3)));
        mIndicatorWidth = ta.getDimension(R.styleable.SlidingTabLayout_tl_indicator_width, dp2px(mIndicatorStyle == STYLE_TRIANGLE ? 7 : -1));
        mIndicatorCornerRadius = ta.getDimension(R.styleable.SlidingTabLayout_tl_indicator_corner_radius, dp2px(mIndicatorStyle == STYLE_BLOCK ? 20 : -1));
        mIndicatorMarginLeft = ta.getDimension(R.styleable.SlidingTabLayout_tl_indicator_margin_left, dp2px(mIndicatorStyle == STYLE_BLOCK ? 10 : 0));
        mIndicatorMarginTop = ta.getDimension(R.styleable.SlidingTabLayout_tl_indicator_margin_top, dp2px(0));
        mIndicatorMarginRight = ta.getDimension(R.styleable.SlidingTabLayout_tl_indicator_margin_right, dp2px(mIndicatorStyle == STYLE_BLOCK ? 10 : 0));
        mIndicatorMarginBottom = ta.getDimension(R.styleable.SlidingTabLayout_tl_indicator_margin_bottom, dp2px(0));
        mIndicatorGravity = ta.getInt(R.styleable.SlidingTabLayout_tl_indicator_gravity, Gravity.BOTTOM);
        mIndicatorWidthEqualTitle = ta.getBoolean(R.styleable.SlidingTabLayout_tl_indicator_width_equal_title, false);

        mUnderlineColor = ta.getColor(R.styleable.SlidingTabLayout_tl_underline_color, Color.parseColor("#ffffff"));
        mUnderlineHeight = ta.getDimension(R.styleable.SlidingTabLayout_tl_underline_height, dp2px(0));
        mUnderlineGravity = ta.getInt(R.styleable.SlidingTabLayout_tl_underline_gravity, Gravity.BOTTOM);

        mDividerColor = ta.getColor(R.styleable.SlidingTabLayout_tl_divider_color, Color.parseColor("#D365D0"));
        mDividerWidth = ta.getDimension(R.styleable.SlidingTabLayout_tl_divider_width, dp2px(0));
        mDividerPadding = ta.getDimension(R.styleable.SlidingTabLayout_tl_divider_padding, dp2px(12));

        mTextsize = ta.getDimension(R.styleable.SlidingTabLayout_tl_textsize, sp2px(15));
        mTextSelectColor = ta.getColor(R.styleable.SlidingTabLayout_tl_textSelectColor, Color.parseColor("#ffffff"));
        mTextUnselectColor = ta.getColor(R.styleable.SlidingTabLayout_tl_textUnselectColor, Color.parseColor("#BED1E4"));
        mTextBold = ta.getInt(R.styleable.SlidingTabLayout_tl_textBold, TEXT_BOLD_NONE);
        mTextAllCaps = ta.getBoolean(R.styleable.SlidingTabLayout_tl_textAllCaps, false);

        mTabSpaceEqual = ta.getBoolean(R.styleable.SlidingTabLayout_tl_tab_space_equal, false);
        mTabWidth = ta.getDimension(R.styleable.SlidingTabLayout_tl_tab_width, dp2px(-1));
        mTabPadding = ta.getDimension(R.styleable.SlidingTabLayout_tl_tab_padding, mTabSpaceEqual || mTabWidth > 0 ? dp2px(0) : dp2px(20));
        ta.recycle();
    }

    public void setViewPager(ViewPager viewPager, ArrayList<CustomTabEntity> arrayList) {
        if (viewPager == null || viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager or ViewPager adapter can not be NULL !");
        }
        this.mViewPager = viewPager;
        this.mTabEntitys.clear();
        this.mTabEntitys.addAll(arrayList);
        this.mViewPager.removeOnPageChangeListener(this);
        this.mViewPager.addOnPageChangeListener(this);
        notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        View view;
        this.mTabsContainer.removeAllViews();
        this.mTabCount = this.mTabEntitys.size();
        for (int i = 0; i < this.mTabCount; i++) {
            if (this.mViewPager.getAdapter() instanceof CustomTabProvider) {
                view = ((CustomTabProvider) this.mViewPager.getAdapter()).getCustomTabView(this, i);
            } else {
                view = View.inflate(this.mContext, R.layout.item_tab, null);
            }
            CharSequence[] charSequenceArr = this.mTitles;
            addTab(i, (charSequenceArr == null ? this.mViewPager.getAdapter().getPageTitle(i) : charSequenceArr[i]).toString(), view);
        }
        updateTabStyles();
    }

    private void addTab(final int i, String str, View view) {
        LinearLayout ll_tab = (LinearLayout) view.findViewById(R.id.ll_tab);
        TextView textView = (TextView) view.findViewById(R.id.tv_tab_title);
        if (!(textView == null || str == null)) {
            textView.setText("#" + str);
        }
        ll_tab.setBackgroundResource(this.mTabEntitys.get(i).getTabUnselectedIcon());
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (SlidingTabLayout.this.mViewPager.getCurrentItem() != i) {
                    SlidingTabLayout.this.mViewPager.setCurrentItem(i);
                    if (SlidingTabLayout.this.mListener != null) {
                        SlidingTabLayout.this.mListener.onTabSelect(i);
                    }
                } else if (SlidingTabLayout.this.mListener != null) {
                    SlidingTabLayout.this.mListener.onTabReselect(i);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = this.mTabSpaceEqual ? new LinearLayout.LayoutParams(0, -1, 1.0f) : new LinearLayout.LayoutParams(-2, -1);
        float f = this.mTabWidth;
        if (f > 0.0f) {
            layoutParams = new LinearLayout.LayoutParams((int) f, -1);
        }
        this.mTabsContainer.addView(view, i, layoutParams);
    }

    @SuppressLint("WrongConstant")
    private void updateTabStyles() {
        int i = 0;
        while (i < this.mTabCount) {
            View childAt = this.mTabsContainer.getChildAt(i);
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            LinearLayout ll_tab = (LinearLayout) childAt.findViewById(R.id.ll_tab);
            if (textView != null) {
                textView.setTextColor(i == this.mCurrentTab ? this.mTextSelectColor : this.mTextUnselectColor);
                textView.setTextSize(0, this.mTextsize);
                float f = this.mTabPadding;
                textView.setPadding((int) f, 0, (int) f, 0);
                CustomTabEntity customTabEntity = this.mTabEntitys.get(i);
                ll_tab.setBackgroundResource(i == this.mCurrentTab ? customTabEntity.getTabSelectedIcon() : customTabEntity.getTabUnselectedIcon());
            }
            i++;
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        this.mCurrentTab = i;
        this.mCurrentPositionOffset = f;
        scrollToCurrentTab();
        invalidate();
    }

    public void onPageSelected(int i) {
        updateTabSelection(i);
    }

    private void scrollToCurrentTab() {
        if (this.mTabCount > 0) {
            int width = (int) (this.mCurrentPositionOffset * ((float) this.mTabsContainer.getChildAt(this.mCurrentTab).getWidth()));
            int left = this.mTabsContainer.getChildAt(this.mCurrentTab).getLeft() + width;
            if (this.mCurrentTab > 0 || width > 0) {
                calcIndicatorRect();
                left = (left - ((getWidth() / 2) - getPaddingLeft())) + ((this.mTabRect.right - this.mTabRect.left) / 2);
            }
            if (left != this.mLastScrollX) {
                this.mLastScrollX = left;
                scrollTo(left, 0);
            }
        }
    }

    private void updateTabSelection(int i) {
        int i2 = 0;
        while (i2 < this.mTabCount) {
            View childAt = this.mTabsContainer.getChildAt(i2);
            boolean z = i2 == i;
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            LinearLayout ll_tab = (LinearLayout) childAt.findViewById(R.id.ll_tab);
            if (textView != null) {
                textView.setTextColor(z ? this.mTextSelectColor : this.mTextUnselectColor);
            }
            if (this.mViewPager.getAdapter() instanceof CustomTabProvider) {
                if (z) {
                    ((CustomTabProvider) this.mViewPager.getAdapter()).tabSelect(childAt);
                } else {
                    ((CustomTabProvider) this.mViewPager.getAdapter()).tabUnselect(childAt);
                }
            }
            CustomTabEntity customTabEntity = this.mTabEntitys.get(i2);
            ll_tab.setBackgroundResource(z ? customTabEntity.getTabSelectedIcon() : customTabEntity.getTabUnselectedIcon());
            i2++;
        }
    }

    private void calcIndicatorRect() {
        View childAt = this.mTabsContainer.getChildAt(this.mCurrentTab);
        float left = (float) childAt.getLeft();
        float right = (float) childAt.getRight();
        if (this.mIndicatorStyle == 0 && this.mIndicatorWidthEqualTitle) {
            this.mTextPaint.setTextSize(this.mTextsize);
            this.margin = ((right - left) - this.mTextPaint.measureText(((TextView) childAt.findViewById(R.id.tv_tab_title)).getText().toString())) / 2.0f;
        }
        int i = this.mCurrentTab;
        if (i < this.mTabCount - 1) {
            View childAt2 = this.mTabsContainer.getChildAt(i + 1);
            float left2 = (float) childAt2.getLeft();
            float right2 = (float) childAt2.getRight();
            float f = this.mCurrentPositionOffset;
            left += (left2 - left) * f;
            right += f * (right2 - right);
            if (this.mIndicatorStyle == 0 && this.mIndicatorWidthEqualTitle) {
                this.mTextPaint.setTextSize(this.mTextsize);
                float f2 = this.margin;
                this.margin = f2 + (this.mCurrentPositionOffset * ((((right2 - left2) - this.mTextPaint.measureText(((TextView) childAt2.findViewById(R.id.tv_tab_title)).getText().toString())) / 2.0f) - f2));
            }
        }
        Rect rect = this.mIndicatorRect;
        int i2 = (int) left;
        rect.left = i2;
        int i3 = (int) right;
        rect.right = i3;
        if (this.mIndicatorStyle == 0 && this.mIndicatorWidthEqualTitle) {
            float f3 = this.margin;
            rect.left = (int) ((left + f3) - 1.0f);
            rect.right = (int) ((right - f3) - 1.0f);
        }
        Rect rect2 = this.mTabRect;
        rect2.left = i2;
        rect2.right = i3;
        if (this.mIndicatorWidth >= 0.0f) {
            float left3 = ((float) childAt.getLeft()) + ((((float) childAt.getWidth()) - this.mIndicatorWidth) / 2.0f);
            int i4 = this.mCurrentTab;
            if (i4 < this.mTabCount - 1) {
                left3 += this.mCurrentPositionOffset * ((float) ((childAt.getWidth() / 2) + (this.mTabsContainer.getChildAt(i4 + 1).getWidth() / 2)));
            }
            Rect rect3 = this.mIndicatorRect;
            rect3.left = (int) left3;
            rect3.right = (int) (((float) rect3.left) + this.mIndicatorWidth);
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.mTabCount > 0) {
            int height = getHeight();
            int paddingLeft = getPaddingLeft();
            float f = this.mDividerWidth;
            if (f > 0.0f) {
                this.mDividerPaint.setStrokeWidth(f);
                this.mDividerPaint.setColor(this.mDividerColor);
                for (int i = 0; i < this.mTabCount - 1; i++) {
                    View childAt = this.mTabsContainer.getChildAt(i);
                    canvas.drawLine((float) (childAt.getRight() + paddingLeft), this.mDividerPadding, (float) (childAt.getRight() + paddingLeft), ((float) height) - this.mDividerPadding, this.mDividerPaint);
                }
            }
            if (this.mUnderlineHeight > 0.0f) {
                this.mRectPaint.setColor(this.mUnderlineColor);
                if (this.mUnderlineGravity == 80) {
                    float f2 = (float) height;
                    canvas.drawRect((float) paddingLeft, f2 - this.mUnderlineHeight, (float) (this.mTabsContainer.getWidth() + paddingLeft), f2, this.mRectPaint);
                } else {
                    canvas.drawRect((float) paddingLeft, 0.0f, (float) (this.mTabsContainer.getWidth() + paddingLeft), this.mUnderlineHeight, this.mRectPaint);
                }
            }
            calcIndicatorRect();
            int i2 = this.mIndicatorStyle;
            if (i2 == 1) {
                if (this.mIndicatorHeight > 0.0f) {
                    this.mTrianglePaint.setColor(this.mIndicatorColor);
                    this.mTrianglePath.reset();
                    float f3 = (float) height;
                    this.mTrianglePath.moveTo((float) (this.mIndicatorRect.left + paddingLeft), f3);
                    this.mTrianglePath.lineTo((float) ((this.mIndicatorRect.left / 2) + paddingLeft + (this.mIndicatorRect.right / 2)), f3 - this.mIndicatorHeight);
                    this.mTrianglePath.lineTo((float) (paddingLeft + this.mIndicatorRect.right), f3);
                    this.mTrianglePath.close();
                    canvas.drawPath(this.mTrianglePath, this.mTrianglePaint);
                }
            } else if (i2 == 2) {
                if (this.mIndicatorHeight < 0.0f) {
                    this.mIndicatorHeight = (((float) height) - this.mIndicatorMarginTop) - this.mIndicatorMarginBottom;
                }
                float f4 = this.mIndicatorHeight;
                if (f4 > 0.0f) {
                    float f5 = this.mIndicatorCornerRadius;
                    if (f5 < 0.0f || f5 > f4 / 2.0f) {
                        this.mIndicatorCornerRadius = this.mIndicatorHeight / 2.0f;
                    }
                    this.mIndicatorDrawable.setColor(this.mIndicatorColor);
                    this.mIndicatorDrawable.setBounds(((int) this.mIndicatorMarginLeft) + paddingLeft + this.mIndicatorRect.left, (int) this.mIndicatorMarginTop, (int) (((float) (paddingLeft + this.mIndicatorRect.right)) - this.mIndicatorMarginRight), (int) (this.mIndicatorMarginTop + this.mIndicatorHeight));
                    this.mIndicatorDrawable.setCornerRadius(this.mIndicatorCornerRadius);
                    this.mIndicatorDrawable.draw(canvas);
                }
            } else if (this.mIndicatorHeight > 0.0f) {
                this.mIndicatorDrawable.setColor(this.mIndicatorColor);
                if (this.mIndicatorGravity == 80) {
                    this.mIndicatorDrawable.setBounds(((int) this.mIndicatorMarginLeft) + paddingLeft + this.mIndicatorRect.left, (height - ((int) this.mIndicatorHeight))
                            - ((int) this.mIndicatorMarginBottom), (paddingLeft + this.mIndicatorRect.right) - ((int) this.mIndicatorMarginRight), height - ((int) this.mIndicatorMarginBottom));
                } else {
                    this.mIndicatorDrawable.setBounds(((int) this.mIndicatorMarginLeft) + paddingLeft + this.mIndicatorRect.left, (int) this.mIndicatorMarginTop, (paddingLeft
                            + this.mIndicatorRect.right) - ((int) this.mIndicatorMarginRight), ((int) this.mIndicatorHeight) + ((int) this.mIndicatorMarginTop));
                }
                this.mIndicatorDrawable.setCornerRadius(this.mIndicatorCornerRadius);
                this.mIndicatorDrawable.draw(canvas);
            }
        }
    }

    public void setTextsize(float f) {
        this.mTextsize = (float) sp2px(f);
        updateTabStyles();
    }

    public float getTextsize() {
        return this.mTextsize;
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("mCurrentTab", this.mCurrentTab);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.mCurrentTab = bundle.getInt("mCurrentTab");
            parcelable = bundle.getParcelable("instanceState");
            if (this.mCurrentTab != 0 && this.mTabsContainer.getChildCount() > 0) {
                updateTabSelection(this.mCurrentTab);
                scrollToCurrentTab();
            }
        }
        super.onRestoreInstanceState(parcelable);
    }

    public int dp2px(float f) {
        return (int) ((f * this.mContext.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public int sp2px(float f) {
        return (int) ((f * this.mContext.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

}