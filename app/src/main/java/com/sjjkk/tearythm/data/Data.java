package com.sjjkk.tearythm.data;

import java.util.List;

/**
 * Created by sjjkk on 2017/9/6.
 */

public class Data {

    private List<ResultBean> result;

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 1
         * name : 针叶白毫
         * taste : 清爽
         * function : 有解毒、退热、降火之功效，有健胃提神、法湿退热之功，常作为药用，常饮能防疫祛病，治疗麻疹
         * age_up : 18
         * age_down : 12
         * taste_q : 清爽
         * function_q : 消脂减肥
         * image_url : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1504243970903&di=7d4e81ae4133d3518965135a4186e36c&imgtype=jpg&src=http%3A%2F%2Fimg0.imgtn.bdimg.com%2Fit%2Fu%3D4023477103%2C4274525023%26fm%3D214%26gp%3D0.jpg
         */

        private int id;
        private String name;
        private String taste;
        private String function;
        private int age_up;
        private int age_down;
        private String taste_q;
        private String function_q;
        private String image_url;
        /**
         * result : [{"id":2,"name":"白牡丹茶","taste":"滋味醇厚清甜，甘醇清新","function":"有润肺清热的功效，常当药用","age_up":40,"age_down":18,"taste_q":"清爽","function_q":"消脂减肥","image_url":"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1807481785,1104654075&fm=26&gp=0.jpg"},{"id":3,"name":"贡眉","taste":"茶味鲜爽，回味甘甜，口齿留香","function":"抗癌及清凉降火的功效，有提高免疫力和保护心血管的显著功效，促进血糖平衡","age_up":40,"age_down":18,"taste_q":"清爽","function_q":"预防心血管疾病","image_url":"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2343302689,1766397448&fm=26&gp=0.jpg"},{"id":4,"name":"寿眉","taste":"优质贡眉毫心显而多，色泽翠绿，汤色橙黄或深黄，味醇爽，香鲜纯。","function":"有清凉解毒，明目降火，抗氧化","age_up":40,"age_down":18,"taste_q":"清爽","function_q":"治疗肠胃不适，降火去燥","image_url":"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3628969329,3407718334&fm=26&gp=0.jpg"},{"id":13,"name":"西湖龙井","taste":"西湖龙井嫩香中带清香，滋味较清鲜柔和","function":"西湖龙井茶是未经发酵而制成的茶性寒，故龙井茶的功效中较为显著的一点即清热、利尿。还可提神、生津止渴、降脂和降胆固醇","age_up":40,"age_down":18,"taste_q":"清爽","function_q":"降脂减肥","image_url":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=38e508598618367ab984778f4f1ae0b1/4a36acaf2edda3ccf46d7d5001e93901213f9231.jpg"},{"id":14,"name":"碧螺春","taste":"泡开后滋味鲜醇、回味甘厚，汤色嫩绿整齐。","function":"使人兴奋，利尿，抑制动脉硬化，强心解痉","age_up":40,"age_down":18,"taste_q":"清爽","function_q":"降脂减肥","image_url":"https://gss0.bdstatic.com/-4o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike92%2C5%2C5%2C92%2C30/sign=c8d0a8b20be93901420f856c1a853f82/962bd40735fae6cdcf80bbf305b30f2442a70f6f.jpg"},{"id":19,"name":"君山银针","taste":"君山银针茶香气清高，味醇甘爽，汤黄澄高","function":"消脂减肥，助消化，清热降火","age_up":40,"age_down":18,"taste_q":"清爽","function_q":"治疗肠胃不适，降火去燥","image_url":"https://gss2.bdstatic.com/-fo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=2800cf09acaf2eddc0fc41bbec796a8c/aa18972bd40735fab8c4ffb69e510fb30f24088c.jpg"}]
         * reason :
         */

        private String reason;
        private List<ResultBean> result;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTaste() {
            return taste;
        }

        public void setTaste(String taste) {
            this.taste = taste;
        }

        public String getFunction() {
            return function;
        }

        public void setFunction(String function) {
            this.function = function;
        }

        public int getAge_up() {
            return age_up;
        }

        public void setAge_up(int age_up) {
            this.age_up = age_up;
        }

        public int getAge_down() {
            return age_down;
        }

        public void setAge_down(int age_down) {
            this.age_down = age_down;
        }

        public String getTaste_q() {
            return taste_q;
        }

        public void setTaste_q(String taste_q) {
            this.taste_q = taste_q;
        }

        public String getFunction_q() {
            return function_q;
        }

        public void setFunction_q(String function_q) {
            this.function_q = function_q;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public List<ResultBean> getResult() {
            return result;
        }

        public void setResult(List<ResultBean> result) {
            this.result = result;
        }
    }
}
