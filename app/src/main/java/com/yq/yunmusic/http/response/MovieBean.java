package com.yq.yunmusic.http.response;

import java.io.Serializable;
import java.util.List;

public class MovieBean implements Serializable {

    private static final long serialVersionUID = -3177266942780645591L;

    /**
     * count : 20
     * start : 0
     * total : 29
     * subjects : [{"rating":{"max":10,"average":5.9,"stars":"30","min":0},"genres":["剧情","爱情"],"title":"后来的我们","casts":[{"alt":"https://movie.douban.com/celebrity/1274628/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1452260519.76.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1452260519.76.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1452260519.76.webp"},"name":"井柏然","id":"1274628"},{"alt":"https://movie.douban.com/celebrity/1274224/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p36798.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p36798.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p36798.webp"},"name":"周冬雨","id":"1274224"},{"alt":"https://movie.douban.com/celebrity/1274287/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1524822270.56.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1524822270.56.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1524822270.56.webp"},"name":"田壮壮","id":"1274287"}],"collect_count":85613,"original_title":"后来的我们","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1041007/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1518407475.38.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1518407475.38.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1518407475.38.webp"},"name":"刘若英","id":"1041007"}],"year":"2018","images":{"small":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2519994468.webp","large":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2519994468.webp","medium":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2519994468.webp"},"alt":"https://movie.douban.com/subject/26683723/","id":"26683723"},{"rating":{"max":10,"average":6.1,"stars":"30","min":0},"genres":["剧情","犯罪","悬疑"],"title":"幕后玩家","casts":[{"alt":"https://movie.douban.com/celebrity/1274297/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p43738.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p43738.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p43738.webp"},"name":"徐峥","id":"1274297"},{"alt":"https://movie.douban.com/celebrity/1313574/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p18662.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p18662.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p18662.webp"},"name":"王丽坤","id":"1313574"},{"alt":"https://movie.douban.com/celebrity/1322085/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1410932305.68.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1410932305.68.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1410932305.68.webp"},"name":"王砚辉","id":"1322085"}],"collect_count":27224,"original_title":"幕后玩家","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1326511/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1520825133.06.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1520825133.06.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1520825133.06.webp"},"name":"任鹏远","id":"1326511"}],"year":"2018","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2520543845.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2520543845.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2520543845.webp"},"alt":"https://movie.douban.com/subject/26774033/","id":"26774033"},{"rating":{"max":10,"average":6.7,"stars":"35","min":0},"genres":["动作","科幻","冒险"],"title":"狂暴巨兽","casts":[{"alt":"https://movie.douban.com/celebrity/1044707/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p196.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p196.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p196.webp"},"name":"道恩·强森","id":"1044707"},{"alt":"https://movie.douban.com/celebrity/1049542/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1486878030.07.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1486878030.07.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1486878030.07.webp"},"name":"娜奥米·哈里斯","id":"1049542"},{"alt":"https://movie.douban.com/celebrity/1044708/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p6531.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p6531.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p6531.webp"},"name":"杰弗里·迪恩·摩根","id":"1044708"}],"collect_count":49533,"original_title":"Rampage","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1317388/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1432840050.06.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1432840050.06.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1432840050.06.webp"},"name":"布拉德·佩顿","id":"1317388"}],"year":"2018","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2516079193.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2516079193.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2516079193.webp"},"alt":"https://movie.douban.com/subject/26430636/","id":"26430636"},{"rating":{"max":10,"average":4.8,"stars":"25","min":0},"genres":["剧情","动作","犯罪"],"title":"低压槽：欲望之城","casts":[{"alt":"https://movie.douban.com/celebrity/1037273/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1376548148.48.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1376548148.48.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1376548148.48.webp"},"name":"张家辉","id":"1037273"},{"alt":"https://movie.douban.com/celebrity/1000571/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20738.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20738.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20738.webp"},"name":"徐静蕾","id":"1000571"},{"alt":"https://movie.douban.com/celebrity/1313023/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p38863.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p38863.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p38863.webp"},"name":"何炅","id":"1313023"}],"collect_count":3633,"original_title":"低壓槽","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1037273/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1376548148.48.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1376548148.48.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1376548148.48.webp"},"name":"张家辉","id":"1037273"}],"year":"2018","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2520457270.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2520457270.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2520457270.webp"},"alt":"https://movie.douban.com/subject/26924141/","id":"26924141"},{"rating":{"max":10,"average":3.9,"stars":"20","min":0},"genres":["奇幻","冒险"],"title":"战神纪","casts":[{"alt":"https://movie.douban.com/celebrity/1275970/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1409055274.95.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1409055274.95.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1409055274.95.webp"},"name":"陈伟霆","id":"1275970"},{"alt":"https://movie.douban.com/celebrity/1345908/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1460438693.8.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1460438693.8.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1460438693.8.webp"},"name":"林允","id":"1345908"},{"alt":"https://movie.douban.com/celebrity/1032540/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20960.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20960.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20960.webp"},"name":"胡军","id":"1032540"}],"collect_count":8646,"original_title":"战神纪","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1275318/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1371547477.26.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1371547477.26.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1371547477.26.webp"},"name":"哈斯朝鲁","id":"1275318"}],"year":"2018","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2519726014.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2519726014.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2519726014.webp"},"alt":"https://movie.douban.com/subject/25881611/","id":"25881611"},{"rating":{"max":10,"average":8.9,"stars":"45","min":0},"genres":["动作","科幻","冒险"],"title":"头号玩家","casts":[{"alt":"https://movie.douban.com/celebrity/1328390/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1464678182.3.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1464678182.3.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1464678182.3.webp"},"name":"泰伊·谢里丹","id":"1328390"},{"alt":"https://movie.douban.com/celebrity/1327806/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p8u95Rxw3ebIcel_avatar_uploaded1365073023.28.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p8u95Rxw3ebIcel_avatar_uploaded1365073023.28.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p8u95Rxw3ebIcel_avatar_uploaded1365073023.28.webp"},"name":" 奥利维亚·库克","id":"1327806"},{"alt":"https://movie.douban.com/celebrity/1000248/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5681.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5681.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5681.webp"},"name":"本·门德尔森","id":"1000248"}],"collect_count":419193,"original_title":"Ready Player One","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1054440/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34602.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34602.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34602.webp"},"name":"史蒂文·斯皮尔伯格","id":"1054440"}],"year":"2018","images":{"small":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2516578307.webp","large":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2516578307.webp","medium":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2516578307.webp"},"alt":"https://movie.douban.com/subject/4920389/","id":"4920389"},{"rating":{"max":10,"average":6.4,"stars":"35","min":0},"genres":["动画","奇幻","冒险"],"title":"玛丽与魔女之花","casts":[{"alt":"https://movie.douban.com/celebrity/1318811/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1363533549.64.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1363533549.64.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1363533549.64.webp"},"name":"杉咲花","id":"1318811"},{"alt":"https://movie.douban.com/celebrity/1185637/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p13768.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p13768.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p13768.webp"},"name":"神木隆之介","id":"1185637"},{"alt":"https://movie.douban.com/celebrity/1059553/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p2941.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p2941.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p2941.webp"},"name":"天海祐希","id":"1059553"}],"collect_count":5822,"original_title":"メアリと魔女の花","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1314163/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1505279964.74.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1505279964.74.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1505279964.74.webp"},"name":"米林宏昌","id":"1314163"}],"year":"2017","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2519631933.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2519631933.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2519631933.webp"},"alt":"https://movie.douban.com/subject/26935777/","id":"26935777"},{"rating":{"max":10,"average":8.4,"stars":"45","min":0},"genres":["喜剧","动画","冒险"],"title":"犬之岛","casts":[{"alt":"https://movie.douban.com/celebrity/1031807/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p39549.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p39549.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p39549.webp"},"name":"布莱恩·科兰斯顿","id":"1031807"},{"alt":"https://movie.douban.com/celebrity/1035676/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p385.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p385.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p385.webp"},"name":"爱德华·诺顿","id":"1035676"},{"alt":"https://movie.douban.com/celebrity/1390746/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1523970333.08.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1523970333.08.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1523970333.08.webp"},"name":"科宇·兰金","id":"1390746"}],"collect_count":67619,"original_title":"Isle of Dogs","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1044872/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1372326428.67.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1372326428.67.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1372326428.67.webp"},"name":"韦斯·安德森","id":"1044872"}],"year":"2018","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2518856022.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2518856022.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2518856022.webp"},"alt":"https://movie.douban.com/subject/26640371/","id":"26640371"},{"rating":{"max":10,"average":5.2,"stars":"30","min":0},"genres":["喜剧","爱情"],"title":"21克拉","casts":[{"alt":"https://movie.douban.com/celebrity/1274663/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p51498.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p51498.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p51498.webp"},"name":"郭京飞","id":"1274663"},{"alt":"https://movie.douban.com/celebrity/1325127/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1516006095.37.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1516006095.37.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1516006095.37.webp"},"name":"迪丽热巴","id":"1325127"},{"alt":"https://movie.douban.com/celebrity/1324043/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1490342249.11.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1490342249.11.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1490342249.11.webp"},"name":"大鹏","id":"1324043"}],"collect_count":13448,"original_title":"21克拉","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1274665/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5962.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5962.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5962.webp"},"name":"何念","id":"1274665"}],"year":"2018","images":{"small":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2518945837.webp","large":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2518945837.webp","medium":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2518945837.webp"},"alt":"https://movie.douban.com/subject/26691361/","id":"26691361"},{"rating":{"max":10,"average":6.5,"stars":"35","min":0},"genres":["剧情"],"title":"黄金花","casts":[{"alt":"https://movie.douban.com/celebrity/1274338/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1378630537.29.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1378630537.29.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1378630537.29.webp"},"name":"毛舜筠","id":"1274338"},{"alt":"https://movie.douban.com/celebrity/1375280/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1516094049.72.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1516094049.72.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1516094049.72.webp"},"name":"凌文龙","id":"1375280"},{"alt":"https://movie.douban.com/celebrity/1037706/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1495.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1495.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1495.webp"},"name":"吕良伟","id":"1037706"}],"collect_count":921,"original_title":"黄金花","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1336976/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1419929763.48.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1419929763.48.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1419929763.48.webp"},"name":"陈大利","id":"1336976"}],"year":"2017","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2520198192.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2520198192.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2520198192.webp"},"alt":"https://movie.douban.com/subject/26868408/","id":"26868408"},{"rating":{"max":10,"average":7.3,"stars":"40","min":0},"genres":["剧情","科幻","惊悚"],"title":"湮灭","casts":[{"alt":"https://movie.douban.com/celebrity/1054454/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p2274.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p2274.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p2274.webp"},"name":"娜塔莉·波特曼","id":"1054454"},{"alt":"https://movie.douban.com/celebrity/1004588/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1424.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1424.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1424.webp"},"name":"詹妮弗·杰森·李","id":"1004588"},{"alt":"https://movie.douban.com/celebrity/1328190/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/pfFyUvfteUGwcel_avatar_uploaded1366276814.07.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/pfFyUvfteUGwcel_avatar_uploaded1366276814.07.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/pfFyUvfteUGwcel_avatar_uploaded1366276814.07.webp"},"name":"吉娜·罗德里格兹","id":"1328190"}],"collect_count":110835,"original_title":"Annihilation","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1284570/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1433647152.45.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1433647152.45.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1433647152.45.webp"},"name":"亚历克斯·嘉兰","id":"1284570"}],"year":"2018","images":{"small":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2516914607.webp","large":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2516914607.webp","medium":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2516914607.webp"},"alt":"https://movie.douban.com/subject/26384741/","id":"26384741"},{"rating":{"max":10,"average":8.5,"stars":"45","min":0},"genres":["动作","战争","犯罪"],"title":"红海行动","casts":[{"alt":"https://movie.douban.com/celebrity/1274761/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1489386626.47.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1489386626.47.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1489386626.47.webp"},"name":"张译","id":"1274761"},{"alt":"https://movie.douban.com/celebrity/1354442/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1458138265.51.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1458138265.51.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1458138265.51.webp"},"name":"黄景瑜","id":"1354442"},{"alt":"https://movie.douban.com/celebrity/1272245/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p49399.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p49399.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p49399.webp"},"name":"海清","id":"1272245"}],"collect_count":385936,"original_title":"红海行动","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1275075/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1372934445.18.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1372934445.18.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1372934445.18.webp"},"name":"林超贤","id":"1275075"}],"year":"2018","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2514119443.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2514119443.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2514119443.webp"},"alt":"https://movie.douban.com/subject/26861685/","id":"26861685"},{"rating":{"max":10,"average":8,"stars":"40","min":0},"genres":["剧情","喜剧"],"title":"起跑线","casts":[{"alt":"https://movie.douban.com/celebrity/1108861/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p48861.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p48861.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p48861.webp"},"name":"伊尔凡·可汗","id":"1108861"},{"alt":"https://movie.douban.com/celebrity/1263714/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1477506649.77.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1477506649.77.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1477506649.77.webp"},"name":"萨巴·卡玛尔","id":"1263714"},{"alt":"https://movie.douban.com/celebrity/1049993/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1521775712.45.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1521775712.45.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1521775712.45.webp"},"name":"内哈·迪胡皮阿","id":"1049993"}],"collect_count":61186,"original_title":"Hindi Medium","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1383681/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1510019957.97.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1510019957.97.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1510019957.97.webp"},"name":"萨基特·乔杜里","id":"1383681"}],"year":"2017","images":{"small":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2517518428.webp","large":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2517518428.webp","medium":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2517518428.webp"},"alt":"https://movie.douban.com/subject/26942631/","id":"26942631"},{"rating":{"max":10,"average":4.4,"stars":"25","min":0},"genres":["动画","冒险","家庭"],"title":"冰雪女王3：火与冰","casts":[{"alt":"https://movie.douban.com/celebrity/1059406/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20303.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20303.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20303.webp"},"name":"迪·布拉雷·贝克尔","id":"1059406"},{"alt":"https://movie.douban.com/celebrity/1390987/","avatars":{"small":"https://img1.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"https://img1.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"洛瑞·加纳","id":"1390987"},{"alt":"https://movie.douban.com/celebrity/1390988/","avatars":{"small":"https://img1.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"https://img1.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"Devin Bailey Griffin","id":"1390988"}],"collect_count":1223,"original_title":"Снежная королева 3: Огонь и лед","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1362482/","avatars":{"small":"https://img1.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"https://img1.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"阿列克谢·特斯蒂斯林","id":"1362482"}],"year":"2016","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2517033932.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2517033932.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2517033932.webp"},"alt":"https://movie.douban.com/subject/26588783/","id":"26588783"},{"rating":{"max":10,"average":0,"stars":"00","min":0},"genres":["纪录片"],"title":"厉害了，我的国","casts":[],"collect_count":124,"original_title":"厉害了，我的国","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1322050/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p52221.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p52221.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p52221.webp"},"name":"卫铁","id":"1322050"}],"year":"2018","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2514293556.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2514293556.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2514293556.webp"},"alt":"https://movie.douban.com/subject/30152451/","id":"30152451"},{"rating":{"max":10,"average":0,"stars":"00","min":0},"genres":["惊悚","恐怖"],"title":"午夜十二点","casts":[{"alt":"https://movie.douban.com/celebrity/1323815/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1360146931.08.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1360146931.08.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1360146931.08.webp"},"name":"谭佑铭","id":"1323815"},{"alt":"https://movie.douban.com/celebrity/1364843/","avatars":{"small":"https://img1.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"https://img1.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"倪新宇","id":"1364843"},{"alt":"https://movie.douban.com/celebrity/1327488/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1363769690.81.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1363769690.81.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1363769690.81.webp"},"name":"胡悦","id":"1327488"}],"collect_count":58,"original_title":"午夜十二点","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1391215/","avatars":{"small":"https://img1.doubanio.com/f/movie/ca527386eb8c4e325611e22dfcb04cc116d6b423/pics/movie/celebrity-default-small.png","large":"https://img3.doubanio.com/f/movie/63acc16ca6309ef191f0378faf793d1096a3e606/pics/movie/celebrity-default-large.png","medium":"https://img1.doubanio.com/f/movie/8dd0c794499fe925ae2ae89ee30cd225750457b4/pics/movie/celebrity-default-medium.png"},"name":"张孝爽","id":"1391215"}],"year":"2018","images":{"small":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2518236317.webp","large":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2518236317.webp","medium":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2518236317.webp"},"alt":"https://movie.douban.com/subject/30187395/","id":"30187395"},{"rating":{"max":10,"average":0,"stars":"00","min":0},"genres":["喜剧"],"title":"尖叫直播","casts":[{"alt":"https://movie.douban.com/celebrity/1351426/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1494494152.36.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1494494152.36.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1494494152.36.webp"},"name":"文松","id":"1351426"},{"alt":"https://movie.douban.com/celebrity/1326496/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p6UqjsvauI4Ucel_avatar_uploaded1359094991.62.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p6UqjsvauI4Ucel_avatar_uploaded1359094991.62.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p6UqjsvauI4Ucel_avatar_uploaded1359094991.62.webp"},"name":"修睿","id":"1326496"},{"alt":null,"avatars":null,"name":"姜玉铬","id":null}],"collect_count":268,"original_title":"尖叫直播","subtype":"movie","directors":[{"alt":null,"avatars":null,"name":"陈晨","id":null},{"alt":"https://movie.douban.com/celebrity/1358070/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1463987507.49.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1463987507.49.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1463987507.49.webp"},"name":"周英男","id":"1358070"}],"year":"2018","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2519542323.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2519542323.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2519542323.webp"},"alt":"https://movie.douban.com/subject/30198302/","id":"30198302"},{"rating":{"max":10,"average":5.6,"stars":"30","min":0},"genres":["喜剧","爱情"],"title":"脱单告急","casts":[{"alt":"https://movie.douban.com/celebrity/1330472/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1514901022.62.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1514901022.62.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1514901022.62.webp"},"name":"董子健","id":"1330472"},{"alt":"https://movie.douban.com/celebrity/1357009/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1513674760.63.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1513674760.63.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1513674760.63.webp"},"name":"钟楚曦","id":"1357009"},{"alt":"https://movie.douban.com/celebrity/1339442/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1464723431.73.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1464723431.73.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1464723431.73.webp"},"name":"春夏","id":"1339442"}],"collect_count":8159,"original_title":"脱单告急","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1317439/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p39868.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p39868.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p39868.webp"},"name":"柯孟融","id":"1317439"}],"year":"2018","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2517694523.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2517694523.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2517694523.webp"},"alt":"https://movie.douban.com/subject/26661189/","id":"26661189"},{"rating":{"max":10,"average":8.3,"stars":"45","min":0},"genres":["剧情","犯罪","悬疑"],"title":"暴裂无声","casts":[{"alt":"https://movie.douban.com/celebrity/1316200/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1449349437.71.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1449349437.71.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1449349437.71.webp"},"name":"宋洋","id":"1316200"},{"alt":"https://movie.douban.com/celebrity/1274290/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p27203.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p27203.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p27203.webp"},"name":"姜武","id":"1274290"},{"alt":"https://movie.douban.com/celebrity/1274820/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p6464.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p6464.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p6464.webp"},"name":"袁文康","id":"1274820"}],"collect_count":82880,"original_title":"暴裂无声","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1341214/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1513848601.01.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1513848601.01.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1513848601.01.webp"},"name":"忻钰坤","id":"1341214"}],"year":"2017","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2517333671.webp","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2517333671.webp","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2517333671.webp"},"alt":"https://movie.douban.com/subject/26647117/","id":"26647117"},{"rating":{"max":10,"average":0,"stars":"00","min":0},"genres":["动画","冒险","家庭"],"title":"小公主艾薇拉与神秘王国","casts":[],"collect_count":29,"original_title":"小公主艾薇拉与神秘王国","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1390831/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1522392000.73.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1522392000.73.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1522392000.73.webp"},"name":"罗洋","id":"1390831"}],"year":"2018","images":{"small":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2517769368.webp","large":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2517769368.webp","medium":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2517769368.webp"},"alt":"https://movie.douban.com/subject/30183489/","id":"30183489"}]
     * title : 正在上映的电影-北京
     */

    private int count;
    private int start;
    private int total;
    private String title;
    private List<SubjectsBean> subjects;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SubjectsBean> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectsBean> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MovieBean{");
        sb.append("count=").append(count);
        sb.append(", start=").append(start);
        sb.append(", total=").append(total);
        sb.append(", title='").append(title).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public static class SubjectsBean {
        /**
         * rating : {"max":10,"average":5.9,"stars":"30","min":0}
         * genres : ["剧情","爱情"]
         * title : 后来的我们
         * casts : [{"alt":"https://movie.douban.com/celebrity/1274628/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1452260519.76.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1452260519.76.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1452260519.76.webp"},"name":"井柏然","id":"1274628"},{"alt":"https://movie.douban.com/celebrity/1274224/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p36798.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p36798.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p36798.webp"},"name":"周冬雨","id":"1274224"},{"alt":"https://movie.douban.com/celebrity/1274287/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1524822270.56.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1524822270.56.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1524822270.56.webp"},"name":"田壮壮","id":"1274287"}]
         * collect_count : 85613
         * original_title : 后来的我们
         * subtype : movie
         * directors : [{"alt":"https://movie.douban.com/celebrity/1041007/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1518407475.38.webp","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1518407475.38.webp","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1518407475.38.webp"},"name":"刘若英","id":"1041007"}]
         * year : 2018
         * images : {"small":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2519994468.webp","large":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2519994468.webp","medium":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2519994468.webp"}
         * alt : https://movie.douban.com/subject/26683723/
         * id : 26683723
         */

        private RatingBean rating;
        private String title;
        private int collect_count;
        private String original_title;
        private String subtype;
        private String year;
        private ImagesBean images;
        private String alt;
        private String id;
        private List<String> genres;
        private List<PersonBean> casts;
        private List<PersonBean> directors;

        public RatingBean getRating() {
            return rating;
        }

        public void setRating(RatingBean rating) {
            this.rating = rating;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getCollect_count() {
            return collect_count;
        }

        public void setCollect_count(int collect_count) {
            this.collect_count = collect_count;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getSubtype() {
            return subtype;
        }

        public void setSubtype(String subtype) {
            this.subtype = subtype;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public ImagesBean getImages() {
            return images;
        }

        public void setImages(ImagesBean images) {
            this.images = images;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<String> getGenres() {
            return genres;
        }

        public void setGenres(List<String> genres) {
            this.genres = genres;
        }

        public List<PersonBean> getCasts() {
            return casts;
        }

        public void setCasts(List<PersonBean> casts) {
            this.casts = casts;
        }

        public List<PersonBean> getDirectors() {
            return directors;
        }

        public void setDirectors(List<PersonBean> directors) {
            this.directors = directors;
        }

        public static class RatingBean {
            /**
             * max : 10
             * average : 5.9
             * stars : 30
             * min : 0
             */

            private int max;
            private double average;
            private String stars;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public double getAverage() {
                return average;
            }

            public void setAverage(double average) {
                this.average = average;
            }

            public String getStars() {
                return stars;
            }

            public void setStars(String stars) {
                this.stars = stars;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }
        }

        public static class ImagesBean {
            /**
             * small : https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2519994468.webp
             * large : https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2519994468.webp
             * medium : https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2519994468.webp
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }

        public static class PersonBean {
            /**
             * alt : https://movie.douban.com/celebrity/1274628/
             * avatars : {"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1452260519.76.webp","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1452260519.76.webp","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1452260519.76.webp"}
             * name : 井柏然
             * id : 1274628
             */

            private String alt;
            private AvatarsBean avatars;
            private String name;
            private String id;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public AvatarsBean getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsBean avatars) {
                this.avatars = avatars;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public static class AvatarsBean {
                /**
                 * small : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1452260519.76.webp
                 * large : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1452260519.76.webp
                 * medium : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1452260519.76.webp
                 */

                private String small;
                private String large;
                private String medium;

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }
            }
        }

    }
}