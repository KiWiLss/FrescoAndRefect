package com.magicsoft.fresco;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * <pre>
 *     author : Lss winding
 *     e-mail : kiwilss@163.com
 *     time   : 2017/12/21
 *     desc   : ${DESCRIPTION}
 *     version: ${VERSION}
 * </pre>
 */


public class FrescoActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_fresco);

        mTextView = new TextView(this);
        initView();
        initError();
    }

    private void initError() {
        SimpleDraweeView sdv3 = (SimpleDraweeView) findViewById(R.id.sdv3);

        //创建将要下载的图片的URI
        Uri imageUri = Uri.parse(url);
        //开始下载
        sdv3.setImageURI(imageUri);
        sdv3.setImageURI(imageUri);
    }

    String url="http://my.csdn.net/uploads/avatar_y1scp.jpg";
    private void initView() {
        //创建SimpleDraweeView对象
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.sdv_one);
        SimpleDraweeView sdvTwo = (SimpleDraweeView) findViewById(R.id.sdv_two);
        //创建将要下载的图片的URI
        Uri imageUri = Uri.parse("http://upload-images.jianshu.io/upload_images/2693519-cd20ad83a38de321.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/700");
        //开始下载
        simpleDraweeView.setImageURI(imageUri);
        sdvTwo.setImageURI(imageUri);
    }
}
