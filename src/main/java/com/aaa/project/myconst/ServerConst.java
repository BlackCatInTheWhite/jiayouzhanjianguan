package com.aaa.project.myconst;

public class ServerConst {
    public static Integer ZERO=0;
    //登录用户如是加油站成员,所属加油站的序号
    public static String GAS_ID="gasid";
    //登录用户如是警察局成员,警察序号
    public static String POLICEMAN_ID="policemanid";
    //任务状态,即有隐患
    public static Integer FMISSIONSTATE_FAILED=1;
    //任务状态,即无隐患
    public static Integer FMISSIONSTATE_SUCCESS=2;
    //加油站状态,即正常
    public static Integer GASSTATE_NORMAL=1;
    //加油站状态,即整改
    public static Integer GASSTATE_RECTIFICATION=2;
    //加油站状态,即未注册
    public static Integer GASSTATE_NOREGISTER=3;
    //加油站状态,即未审核
    public static Integer GASSTATE_NOAGREE=4;
    //加油站状态,即已审核
    public static Integer GASSTATE_AGREE=5;
    //加油站状态,即待巡检
    public static Integer GASSTATE_MISSION=6;
    //用户表,所属部门,即豆豆科技
    public static Long USER_DEPTID_PARENT=100L;
    //用户表,所属部门,即加油站
    public static Long USER_DEPTID_GAS=110L;
    //用户表,所属部门,即警察局
    public static Long USER_DEPTID_POLICE=111L;
    //用户表,Email信息
    public static String USER_EMAIL="957945717@qq.com";
    //用户表,性别,即男
    public static String USER_SEX_MAN="0";
    //用户表,性别,即女
    public static String USER_SEX_WOMAN="1";
    //用户表,状态,即女
    public static String USER_STATUS="0";
    //用户表,角色,即普通员工
    public static Long[] USER_POSTIDS=new Long[]{4L};
    //用户表,权限,即警察
    public static Long[] USER_ROLEIDS_POLICE=new Long[]{3L};
    //用户表,权限,即加油站
    public static Long[] USER_ROLEIDS_GAS=new Long[]{4L};
    //用户表,盐值
    public static String USER_SALT="111111";
    //加油站注册巡检任务间隔
    public static Integer ZMISSION_INTERVAL=1;
}
