package com.study.jedis.domain.vo;

public  class ListWechatVo {
            /**
             * title : 玻璃大王曹德旺“跑路”事件
             * month : 12
             * img : http://img.lssdjt.com/201701/09094304507.jpg
             * year : 2016
             * day : 20
             */

            private String title;
            private int month;
            private String img;
            private String year;
            private int day;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getMonth() {
                return month;
            }

            public void setMonth(int month) {
                this.month = month;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getYear() {
                return year;
            }

            public void setYear(String year) {
                this.year = year;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }
        }