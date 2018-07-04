package news.chen.yu.ionic;

import org.apache.cordova.*;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.bean.SHARE_MEDIA;

public class UMShareWeibo extends CordovaPlugin {

    private Boolean __init = false;

    private void init() {
        if(!this.__init) {
            this.__init = true;
            if(!UMShare.mediaList.contains(SHARE_MEDIA.SINA))
                UMShare.mediaList.add(SHARE_MEDIA.SINA);
            String appKey = preferences.getString("um_share_weibo_key", "");
            String appSecret = preferences.getString("um_share_weibo_secret", "");
            PlatformConfig.setSinaWeibo(appKey, appSecret, "http://sns.whalecloud.com/sina2/callback");
        }
    }

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        this.init();
    }
}