#import "UMShareWeibo.h"

@implementation UMShareWeibo
- (void)pluginInitialize
{
    
    [[NSNotificationCenter defaultCenter] addObserver:self selector:@selector(finishLaunching:) name:UIApplicationDidFinishLaunchingNotification object:nil];
    
}

- (void)finishLaunching:(NSNotification *)notification
{
    // Put here the code that should be on the AppDelegate.m
    // 获取AppKey
    NSString *appKey = [[self.commandDelegate settings] objectForKey:@"um_share_weibo_key"];
    NSString *appSecret = [[self.commandDelegate settings] objectForKey:@"um_share_weibo_secret"];

    [[UMSocialManager defaultManager] setPlaform:UMSocialPlatformType_Sina appKey:appKey appSecret:appSecret redirectURL:@"http://sns.whalecloud.com/sina2/callback"];
}

@end
