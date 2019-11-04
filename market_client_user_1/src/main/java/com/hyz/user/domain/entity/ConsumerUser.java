package com.hyz.user.domain.entity;

public class ConsumerUser {

    private String f_user_id;
    private String f_user_email;
    private String f_user_pwd;
    private String f_user_tel;
    private int f_user_credits;// '积分(活跃度)
    private long f_user_level_id;// '用户VIP级别(bq_member_level:level_id)',
    private int f_user_state;// '用户状态（0:无效,1:有效,-1:冻结）
    private String f_user_salt;// 密码随机码6位salt
    private int f_user_time;// 注册时间,unix时间格式
    private int f_user_email_status;// '邮箱认证(1:已认证 0:未认证)',

    public String getF_user_id() {
        return f_user_id;
    }

    public void setF_user_id(String f_user_id) {
        this.f_user_id = f_user_id;
    }

    public String getF_user_email() {
        return f_user_email;
    }

    public void setF_user_email(String f_user_email) {
        this.f_user_email = f_user_email;
    }

    public String getF_user_pwd() {
        return f_user_pwd;
    }

    public void setF_user_pwd(String f_user_pwd) {
        this.f_user_pwd = f_user_pwd;
    }

    public String getF_user_tel() {
        return f_user_tel;
    }

    public void setF_user_tel(String f_user_tel) {
        this.f_user_tel = f_user_tel;
    }

    public int getF_user_credits() {
        return f_user_credits;
    }

    public void setF_user_credits(int f_user_credits) {
        this.f_user_credits = f_user_credits;
    }

    public long getF_user_level_id() {
        return f_user_level_id;
    }

    public void setF_user_level_id(long f_user_level_id) {
        this.f_user_level_id = f_user_level_id;
    }

    public int getF_user_state() {
        return f_user_state;
    }

    public void setF_user_state(int f_user_state) {
        this.f_user_state = f_user_state;
    }

    public String getF_user_salt() {
        return f_user_salt;
    }

    public void setF_user_salt(String f_user_salt) {
        this.f_user_salt = f_user_salt;
    }

    public int getF_user_time() {
        return f_user_time;
    }

    public void setF_user_time(int f_user_time) {
        this.f_user_time = f_user_time;
    }

    public int getF_user_email_status() {
        return f_user_email_status;
    }

    public void setF_user_email_status(int f_user_email_status) {
        this.f_user_email_status = f_user_email_status;
    }
}
