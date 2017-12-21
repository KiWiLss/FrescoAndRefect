package com.magicsoft.refect.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.RequestOptions;
import com.magicsoft.refect.R;
import com.magicsoft.refect.utils.GlideUtils;

import java.io.File;
import java.util.concurrent.ExecutionException;

import jp.wasabeef.glide.transformations.GrayscaleTransformation;

/**
 * <pre>
 *     author : Lss winding
 *     e-mail : kiwilss@163.com
 *     time   : 2017/12/21
 *     desc   : ${DESCRIPTION}
 *     version: ${VERSION}
 * </pre>
 */


public class GlideActivity extends AppCompatActivity {

    private ImageView mIvIcon;
    private ImageView mIvIcon2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        initView();

        //调用预加载
        Glide.with(this)
                .load("http://guolin.tech/book.png")
                .preload();

        int jj2 = R.mipmap.jj2;
        Log.e("MMM", "onCreate: "+jj2);
    }

    private void initView() {
        mIvIcon = (ImageView) findViewById(R.id.iv_icon);
        mIvIcon2 = (ImageView) findViewById(R.id.iv_icon2);

    }
    String url = "http://guolin.tech/book.png";
    public void loadImage(View view) {

        Glide.with(this).load(url).into(mIvIcon);
    }

    public void palacer(View view) {
        RequestOptions requestOptions = new RequestOptions().placeholder(R.mipmap.jj2);

        Glide.with(this).load(url)
                .apply(requestOptions).into(mIvIcon);

    }

    public void clear(View view) {
        Glide.with(this).clear(mIvIcon);
    }

    public void palacerNoCache(View view) {
        RequestOptions requestOptions = new RequestOptions().placeholder(R.mipmap.jj2)
                .diskCacheStrategy(DiskCacheStrategy.NONE);

        Glide.with(this).load(url)
                .apply(requestOptions).into(mIvIcon);
    }

    public void widthHeight(View view) {
        RequestOptions requestOptions = new RequestOptions().placeholder(R.mipmap.jj2)
                .override(200,200)
                .diskCacheStrategy(DiskCacheStrategy.NONE);

        Glide.with(this).load(url)
                .apply(requestOptions).into(mIvIcon);
    }

    public void gif(View view) {
        Glide.with(this)
                .load("http://guolin.tech/test.gif")
                .into(mIvIcon);
    }

    public void getFile(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                FutureTarget<File> target = Glide.with(GlideActivity.this).asFile()
                        .load("http://guolin.tech/test.gif")
                        .submit();

                try {
                    final File file = target.get();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            Log.e("MMM", "run: "+file+"||"+file.getPath());
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }


            }
        }).start();
    }

    public void circle(View view) {

    GlideUtils.getInstance().loadImgResourceCircle(this,R.mipmap.jj2,mIvIcon);
//        RequestOptions requestOptions = new RequestOptions()
//                .placeholder(R.mipmap.jj2)
//                .circleCrop();
//        Glide.with(this)
//                .load(url)
//                .apply(requestOptions)
//                .into(mIvIcon);
    }

    public void gray(View view) {
        String url = "http://guolin.tech/book.png";
        RequestOptions options = new RequestOptions()
                .transforms(new GrayscaleTransformation());
        Glide.with(this)
                .load(url)
                .apply(options)
                .into(mIvIcon);
    }

    public void round(View view) {
        GlideUtils.getInstance().loadImgResourceRound(this,R.mipmap.jj2,mIvIcon,30);
    }

    public void circle2(View view) {
        //GlideUtils.getInstance().loadImgResourceCircle2(this,R.mipmap.jj2,mIvIcon2);
        GlideUtils.getInstance().loadImg(this,R.mipmap.jj2,mIvIcon,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.color.colorAccent);
    }

    public void square(View view) {
        //GlideUtils.getInstance().loadImgSquare(this,url,mIvIcon2,R.mipmap.jj2);
        GlideUtils.getInstance().loadImgBlur(this,R.mipmap.jj2,mIvIcon2,R.mipmap.jj2,R.mipmap.jj2,25);
    }
}
