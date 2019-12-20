package com.study.jedis.domain.vo;

import java.util.List;

public  class ShowapiResBodyWechatVo {
    /**
     * ret_code : 0
     * list : [{"title":"玻璃大王曹德旺\u201c跑路\u201d事件","month":12,"img":"http://img.lssdjt.com/201701/09094304507.jpg","year":"2016","day":20},{"title":"深圳滑坡事故","month":12,"img":"http://img.lssdjt.com/201512/23213258955.jpg","year":"2015","day":20},{"title":"公安部原副部长李东生被查","month":12,"img":"http://img.lssdjt.com/201504/28233807573.jpg","year":"2013","day":20},{"title":"胡锦涛会见澳门特别行政区新任行政长官崔世安","month":12,"img":"http://img.lssdjt.com/201112/20/51142050524.jpg","year":"2009","day":20},{"title":"美国纽约公交系统罢工，全市交通陷入混乱","month":12,"img":"http://img.lssdjt.com/201112/20/2F141942698.jpg","year":"2005","day":20},{"title":"卢武铉当选韩国第十六届总统","month":12,"img":"http://img.lssdjt.com/200912/7/2523837592.jpg","year":"2002","day":20},{"title":"中葡两国政府澳门政权交接仪式隆重举行","month":12,"img":"http://img.lssdjt.com/200412/20/3502847124.jpg","year":"1999","day":20},{"title":"澳门回归祖国","month":12,"img":"http://img.lssdjt.com/200905/17/0E232050900.jpg","year":"1999","day":20},{"title":"世界首例平安降生的八胞胎在美国休斯敦降生","month":12,"img":"http://img.lssdjt.com/200912/7/BA231546925.jpg","year":"1998","day":20},{"title":"德捷妥善处理历史遗留问题","month":12,"year":"1996","day":20},{"title":"我国首座悬索桥海湾大桥竣工","month":12,"img":"http://img.lssdjt.com/200912/7/DE232039237.jpg","year":"1995","day":20},{"title":"我国出现首家期货经纪公司","month":12,"year":"1992","day":20},{"title":"武陵源、九寨沟、黄龙成为\u201c世界级\u201d自然遗产","month":12,"img":"http://img.lssdjt.com/200912/7/D123256379.jpg","year":"1992","day":20},{"title":"美军入侵巴拿马纪实","month":12,"img":"http://img.lssdjt.com/200905/17/49232443958.jpg","year":"1989","day":20},{"title":"我国兴建当时第二大水电站","month":12,"year":"1987","day":20},{"title":"阿拉法特及巴解士兵撤出的黎波里","month":12,"img":"http://img.lssdjt.com/200905/17/DC232715679.jpg","year":"1983","day":20},{"title":"湖南人工繁殖娃娃鱼成功","month":12,"img":"http://img.lssdjt.com/201112/20/AD12173249.jpg","year":"1980","day":20},{"title":"美国小说家约翰·斯坦倍克去","month":12,"img":"http://img.lssdjt.com/200905/17/EE232948204.jpg","year":"1968","day":20},{"title":"越南南方民族解放阵线成立","month":12,"year":"1960","day":20},{"title":"苏联制成世界上第一架电子排版机","month":12,"year":"1959","day":20},{"title":"我国与阿尔及利亚建交","month":12,"img":"http://img.lssdjt.com/201511/08215427413.jpg","year":"1958","day":20},{"title":"天津战役开始","month":12,"img":"http://img.lssdjt.com/200905/17/20233210126.jpg","year":"1948","day":20},{"title":"胡志明发表《全民抗战号召书》","month":12,"img":"http://img.lssdjt.com/201112/20/2C12196880.jpg","year":"1946","day":20},{"title":"马歇尔来华调停国共关系","month":12,"year":"1945","day":20},{"title":"德\u201c施佩伯爵\u201d号遭英舰围困自沉","month":12,"img":"http://img.lssdjt.com/200905/17/A7233355734.jpg","year":"1939","day":20},{"title":"全俄肃反委员会成立","month":12,"year":"1917","day":20},{"title":"满洲里界约","month":12,"img":"http://img.lssdjt.com/201703/13230222388.jpg","year":"1911","day":20},{"title":"甘露之变","month":12,"year":"835","day":20},{"title":"唐代高僧鉴真东渡日本","month":12,"img":"http://img.lssdjt.com/201112/20/68122424369.jpg","year":"753","day":20}]
     */

    private int ret_code;
    private List<ListWechatVo> list;

    public int getRet_code() {
        return ret_code;
    }

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
    }

    public List<ListWechatVo> getList() {
        return list;
    }

    public void setList(List<ListWechatVo> list) {
        this.list = list;
    }
}