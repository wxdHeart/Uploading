package com.example.schoo.Bean;

import java.util.List;

public class User {

    /**
     * error : false
     * results : [{"createdAt":"2019-05-04T16:21:53.523Z","publishedAt":"2019-05-04T16:21:59.733Z","_id":"5ccdbc219d212239df927a93","source":"web","used":true,"type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1g2pquqlp0nj30n00yiq8u.jpg","desc":"2019-05-05","who":"lijinshanmx"},{"createdAt":"2019-04-27T19:12:25.536Z","publishedAt":"2019-04-27T19:12:51.865Z","_id":"5cc43919fc3326376038d233","source":"web","used":true,"type":"福利","url":"https://ww1.sinaimg.cn/large/0065oQSqly1g2hekfwnd7j30sg0x4djy.jpg","desc":"2019-04-27","who":"lijinshanmx"},{"createdAt":"2019-02-18T06:04:25.571Z","publishedAt":"2019-04-10T00:00:00.0Z","_id":"5c6a4ae99d212226776d3256","source":"web","used":true,"type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqly1g0ajj4h6ndj30sg11xdmj.jpg","desc":"2019-02-18","who":"lijinshanmx"},{"createdAt":"2019-01-03T06:29:47.895Z","publishedAt":"2019-01-03T00:00:00.0Z","_id":"5c2dabdb9d21226e068debf9","source":"web","used":true,"type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqly1fytdr77urlj30sg10najf.jpg","desc":"2019-01-03","who":"lijinshanmx"},{"createdAt":"2018-12-28T08:13:12.688Z","publishedAt":"2018-12-28T00:00:00.0Z","_id":"5c25db189d21221e8ada8664","source":"web","used":true,"type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqly1fymj13tnjmj30r60zf79k.jpg","desc":"2018-12-28","who":"lijinshanmx"},{"createdAt":"2018-12-13T09:07:57.2Z","publishedAt":"2018-12-13T00:00:00.0Z","_id":"5c12216d9d21223f5a2baea2","source":"web","used":true,"type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqgy1fy58bi1wlgj30sg10hguu.jpg","desc":"2018-12-13","who":"lijinshanmx"},{"createdAt":"2018-11-28T04:32:27.338Z","publishedAt":"2018-11-28T00:00:00.0Z","_id":"5bfe1a5b9d2122309624cbb7","source":"web","used":true,"type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqgy1fxno2dvxusj30sf10nqcm.jpg","desc":"2018-11-28","who":"lijinshanmx"},{"createdAt":"2018-11-19T03:36:54.950Z","publishedAt":"2018-11-19T00:00:00.0Z","_id":"5bf22fd69d21223ddba8ca25","source":"web","used":true,"type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqgy1fxd7vcz86nj30qo0ybqc1.jpg","desc":"2018-11-19","who":"lijinshanmx"},{"createdAt":"2018-11-06T08:20:43.656Z","publishedAt":"2018-11-06T00:00:00.0Z","_id":"5be14edb9d21223dd50660f8","source":"web","used":true,"type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqgy1fwyf0wr8hhj30ie0nhq6p.jpg","desc":"2018-11-06","who":"lijinshanmx"},{"createdAt":"2018-10-22T06:43:35.440Z","publishedAt":"2018-10-22T00:00:00.0Z","_id":"5bcd71979d21220315c663fc","source":"web","used":true,"type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqgy1fwgzx8n1syj30sg15h7ew.jpg","desc":"2018-10-22","who":"lijinshanmx"},{"createdAt":"2018-10-15T06:33:16.497Z","publishedAt":"2018-10-15T00:00:00.0Z","_id":"5bc434ac9d212279160c4c9e","source":"web","used":true,"type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqly1fw8wzdua6rj30sg0yc7gp.jpg","desc":"2018-10-15","who":"lijinshanmx"},{"createdAt":"2018-10-08T07:57:20.978Z","publishedAt":"2018-10-08T00:00:00.0Z","_id":"5bbb0de09d21226111b86f1c","source":"web","used":true,"type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqly1fw0vdlg6xcj30j60mzdk7.jpg","desc":"2018-10-08","who":"lijinshanmx"},{"createdAt":"2018-09-19T08:21:00.295Z","publishedAt":"2018-09-19T00:00:00.0Z","_id":"5ba206ec9d2122610aba3440","source":"web","used":true,"type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqly1fvexaq313uj30qo0wldr4.jpg","desc":"2018-09-19","who":"lijinshanmx"},{"createdAt":"2018-09-11T07:41:22.491Z","publishedAt":"2018-09-11T00:00:00.0Z","_id":"5b9771a29d212206c1b383d0","source":"web","used":true,"type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqly1fv5n6daacqj30sg10f1dw.jpg","desc":"2018-09-11","who":"lijinshanmx"},{"createdAt":"2018-08-27T04:21:14.703Z","publishedAt":"2018-08-28T00:00:00.0Z","_id":"5b830bba9d2122031f86ee51","source":"web","used":true,"type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqly1fuo54a6p0uj30sg0zdqnf.jpg","desc":"2018-08-27","who":"lijinshanmx"},{"createdAt":"2018-08-21T11:13:48.989Z","publishedAt":"2018-08-21T00:00:00.0Z","_id":"5b7b836c9d212201e982de6e","source":"web","used":true,"type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqly1fuh5fsvlqcj30sg10onjk.jpg","desc":"2018-08-21","who":"lijinshanmx"},{"createdAt":"2018-08-16T11:02:24.289Z","publishedAt":"2018-08-16T00:00:00.0Z","_id":"5b74e9409d21222c52ae4cb4","source":"api","used":true,"type":"福利","url":"https://ws1.sinaimg.cn/large/0065oQSqly1fubd0blrbuj30ia0qp0yi.jpg","desc":"2018-08-16","who":"lijinshan"},{"createdAt":"2018-08-13T12:00:52.458Z","publishedAt":"2018-08-13T00:00:00.0Z","_id":"5b7102749d2122341d563844","source":"api","used":true,"type":"福利","url":"https://ww1.sinaimg.cn/large/0065oQSqly1fu7xueh1gbj30hs0uwtgb.jpg","desc":"2018-08-13","who":"lijinshan"},{"createdAt":"2018-08-09T10:56:04.962Z","publishedAt":"2018-08-09T00:00:00.0Z","_id":"5b6bad449d21226f45755582","source":"web","used":true,"type":"福利","url":"https://ww1.sinaimg.cn/large/0065oQSqgy1fu39hosiwoj30j60qyq96.jpg","desc":"2018-08-09","who":"lijinshanmx"},{"createdAt":"2018-08-06T10:52:45.809Z","publishedAt":"2018-08-06T00:00:00.0Z","_id":"5b67b7fd9d2122195bdbd806","source":"api","used":true,"type":"福利","url":"https://ww1.sinaimg.cn/large/0065oQSqly1ftzsj15hgvj30sg15hkbw.jpg","desc":"2018-08-06","who":"lijinshan"}]
     */
    private boolean error;
    private List<ResultsEntity> results;

    public void setError(boolean error) {
        this.error = error;
    }

    public void setResults(List<ResultsEntity> results) {
        this.results = results;
    }

    public boolean isError() {
        return error;
    }

    public List<ResultsEntity> getResults() {
        return results;
    }

    public class ResultsEntity {
        /**
         * createdAt : 2019-05-04T16:21:53.523Z
         * publishedAt : 2019-05-04T16:21:59.733Z
         * _id : 5ccdbc219d212239df927a93
         * source : web
         * used : true
         * type : 福利
         * url : http://ww1.sinaimg.cn/large/0065oQSqly1g2pquqlp0nj30n00yiq8u.jpg
         * desc : 2019-05-05
         * who : lijinshanmx
         */
        private String createdAt;
        private String publishedAt;
        private String _id;
        private String source;
        private boolean used;
        private String type;
        private String url;
        private String desc;
        private String who;

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public String get_id() {
            return _id;
        }

        public String getSource() {
            return source;
        }

        public boolean isUsed() {
            return used;
        }

        public String getType() {
            return type;
        }

        public String getUrl() {
            return url;
        }

        public String getDesc() {
            return desc;
        }

        public String getWho() {
            return who;
        }
    }
}
