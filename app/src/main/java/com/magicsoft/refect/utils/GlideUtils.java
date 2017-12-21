package com.magicsoft.refect.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.io.File;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.ColorFilterTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.CropSquareTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * <pre>
 *     author : Lss winding
 *     e-mail : kiwilss@163.com
 *     time   : 2017/12/21
 *     desc   : ${DESCRIPTION}
 *     version: ${VERSION}
 * </pre>
 */


public class GlideUtils {

    private GlideUtils(){}

    static class GlideUtilsHodler{
        public static final GlideUtils GLIDE_UTILS=new GlideUtils();
    }

    public static GlideUtils getInstance(){
        return GlideUtilsHodler.GLIDE_UTILS;
    }

    /**
     常用方法
     */

    //一般的加载
    public void loadImg(Context context, String path, ImageView img){
        if (img != null&& !TextUtils.isEmpty(path)){
            Glide.with(context).load(path).into(img);
        }
    }
    //一般的加载,设置加载错误的图片
    public void loadImg(Context context, String path, ImageView img,int errorImg){
        if (img!=null && !TextUtils.isEmpty(path)){
            RequestOptions requestOptions = new RequestOptions().error(errorImg);
            Glide.with(context).load(path).apply(requestOptions).into(img);
        }
    }
    //一般的加载,设置加载错误的图片,占位符
    public void loadImg(Context context, String path, ImageView img,int errorImg,int place){
        if (img!=null && !TextUtils.isEmpty(path)){
            RequestOptions requestOptions = new RequestOptions().placeholder(place).error(errorImg);
            Glide.with(context).load(path).apply(requestOptions).into(img);
        }
    }

    //一般的加载圆形图片
    public void loadImgCircle(Context context,String path,ImageView img,int errorImg){
        if (img!=null&&!TextUtils.isEmpty(path)){
            RequestOptions requestOptions = new RequestOptions().circleCrop().error(errorImg);
            Glide.with(context).load(path).apply(requestOptions).into(img);
        }
    }
    //一般的加载圆形图片,占位符
    public void loadImgCircle(Context context,String path,ImageView img,int errorImg,int place){
        if (img!=null&&!TextUtils.isEmpty(path)){
            RequestOptions requestOptions = new RequestOptions().placeholder(place).circleCrop().error(errorImg);
            Glide.with(context).load(path).apply(requestOptions).into(img);
        }
    }
    //一般的加载圆角图片
    public void loadImgRound(Context context,String path,ImageView img,int errorImg,int round){
        if (img!=null && !TextUtils.isEmpty(path)){
            RequestOptions requestOptions = new RequestOptions().error(errorImg)
                    .transform(new RoundedCornersTransformation(round,0, RoundedCornersTransformation.CornerType.ALL));
            Glide.with(context).load(path).apply(requestOptions).into(img);
        }
    }
    //一般的加载圆角图片
    public void loadImgRound(Context context,String path,ImageView img,int errorImg,int place,int round){
        if (img!=null && !TextUtils.isEmpty(path)){
            RequestOptions requestOptions = new RequestOptions().error(errorImg).placeholder(place)
                    .transform(new RoundedCornersTransformation(round,0, RoundedCornersTransformation.CornerType.ALL));
            Glide.with(context).load(path).apply(requestOptions).into(img);
        }
    }

    //设置加载中的图片和加载错误的图片
    public void loadImgLoading(Context context, String path,
                               ImageView img,int loadImg,int errorImg){
        if (img!=null && !TextUtils.isEmpty(path)){
            RequestOptions requestOptions = new RequestOptions()
                    .placeholder(loadImg)
                    .error(errorImg);
            Glide.with(context).load(path).apply(requestOptions).into(img);
        }
    }

    /**加载正方形
     * @param context
     * @param path
     * @param img
     */
    public void loadImgSquare(Context context,String path,ImageView img,int error){
        if (img != null  && !TextUtils.isEmpty(path)){
            RequestOptions requestOptions = new RequestOptions()
                    .error(error)
                    .transform(new CropSquareTransformation());
            Glide.with(context).load(path).apply(requestOptions).into(img);
        }
    }

    public void loadImgSquare(Context context,String path,ImageView img,int error,int place){
        if (img != null  && !TextUtils.isEmpty(path)){
            RequestOptions requestOptions = new RequestOptions()
                    .placeholder(place)
                    .error(error)
                    .transform(new CropSquareTransformation());
            Glide.with(context).load(path).apply(requestOptions).into(img);
        }
    }

    /**
     * 图片颜色转换
     */
   public void loadImg(Context context,String path,ImageView img,int error,int place,int color){
       if (img!=null && !TextUtils.isEmpty(path)){
           RequestOptions requestOptions = new RequestOptions().placeholder(place).error(error)
                   .transform(new ColorFilterTransformation(color));
           Glide.with(context).load(path).apply(requestOptions).into(img);
       }
   }
    /**
     * 本地图片颜色转换
     */
    public void loadImg(Context context,int path,ImageView img,int error,int place,int color){
        if (img!=null ){
            RequestOptions requestOptions = new RequestOptions().placeholder(place).error(error)
                    .transform(new ColorFilterTransformation(color));
            Glide.with(context).load(path).apply(requestOptions).into(img);
        }
    }
    /**
     * 图片灰化
     */
    public void loadImgGray(Context context,String path,ImageView img,int error,int place){
        if (img!=null && !TextUtils.isEmpty(path)){
            RequestOptions requestOptions = new RequestOptions().placeholder(place).error(error)
                    .transform(new GrayscaleTransformation());
            Glide.with(context).load(path).apply(requestOptions).into(img);
        }
    }

    /**
     * 图片模糊
     */
    public void loadImgBlur(Context context,String path,ImageView img,int error,int place,int blur){
        if (img!=null && !TextUtils.isEmpty(path)){
            RequestOptions requestOptions = new RequestOptions().placeholder(place).error(error)
                    .transform(new BlurTransformation(blur));//// radius : 离散半径/模糊度（单参构造器 - 默认25）
            // sampling : 取样（单参构造器 - 默认1） 如果取2，横向、纵向都会每两个像素点取一个像素点(即:图片宽高变为原来一半)
            Glide.with(context).load(path).apply(requestOptions).into(img);
        }
    }

    /**
     * 本地图片模糊
     */
    public void loadImgBlur(Context context,int path,ImageView img,int error,int place,int blur){
        if (img!=null ){
            RequestOptions requestOptions = new RequestOptions().placeholder(place).error(error)
                    .transform(new BlurTransformation(blur));//// radius : 离散半径/模糊度（单参构造器 - 默认25）
            // sampling : 取样（单参构造器 - 默认1） 如果取2，横向、纵向都会每两个像素点取一个像素点(即:图片宽高变为原来一半)
            Glide.with(context).load(path).apply(requestOptions).into(img);
        }
    }

    //一般的加载本地资源图片
    public void loadImgResource(Context context,int resource,ImageView img){
        if (img != null){
            Glide.with( context).load(resource).into(img);
        }
    }
    //一般的加载文件图片
    public void loadImgFile(Context context, File file, ImageView imageView){
        if (imageView!=null && file.exists()){
            Glide.with(context).load(file).into(imageView);
        }
    }

    //设置本地图片圆形
    public void loadImgResourceCircle(Context context,int resource,ImageView img){
        if (img!=null){
            RequestOptions requestOptions = new RequestOptions().circleCrop();
            Glide.with( context).load(resource).apply(requestOptions).into(img);
        }
    }
    //设置本地图片圆形
    public void loadImgResourceCircle2(Context context,int resource,ImageView img){
        if (img!=null){
            RequestOptions requestOptions = new RequestOptions()
                    .transform(new CropCircleTransformation());
            Glide.with( context).load(resource).apply(requestOptions).into(img);
        }
    }

    //设置加载本地图片圆角
    public void loadImgResourceRound(Context context,int resource,ImageView img,int round){
        if (img!=null){
            RequestOptions requestOptions = new RequestOptions()
                    .transform(new RoundedCornersTransformation(round,0, RoundedCornersTransformation.CornerType.ALL));
            Glide.with( context).load(resource).apply(requestOptions).into(img);
        }
    }




    //跳过内存缓存
    public void loadImageViewCache(Context context, String path, ImageView img) {
        if (img!=null && !TextUtils.isEmpty(path)){
            RequestOptions requestOptions = new RequestOptions()
                    .skipMemoryCache(true);
            Glide.with(context).load(path).apply(requestOptions).into(img);
        }
    }
    //设置下载优先级
    public void loadImageViewPriority(Context context, String path, ImageView img) {
        if (img!=null && !TextUtils.isEmpty(path)){
            RequestOptions requestOptions = new RequestOptions()
                    .priority(Priority.HIGH);
            Glide.with(context).load(path).apply(requestOptions).into(img);
        }
    }
    //设置缓存策略
    public void loadImageViewDiskCache(Context context, String path, ImageView img) {
        if (img!=null && !TextUtils.isEmpty(path)){
            RequestOptions requestOptions = new RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.ALL);
            Glide.with(context).load(path).apply(requestOptions).into(img);
        }
    }

    //设置缩略图支持
    public void loadImageViewThumbnail(Context mContext, String path, ImageView mImageView) {
        Glide.with(mContext).load(path).thumbnail(0.1f).into(mImageView);
    }
    //清理磁盘缓存
    public static void GuideClearDiskCache(Context mContext) {
        //理磁盘缓存 需要在子线程中执行
        Glide.get(mContext).clearDiskCache();
    }
    //清理内存缓存
    public static void GuideClearMemory(Context mContext) {
        //清理内存缓存  可以在UI主线程中进行
        Glide.get(mContext).clearMemory();
    }

    /**
     * 清理所有缓存,在子线程中执行
     */
    public void clear(Context context){
        //理磁盘缓存 需要在子线程中执行
        Glide.get(context).clearDiskCache();
        //清理内存缓存  可以在UI主线程中进行
        Glide.get(context).clearMemory();
    }
}
