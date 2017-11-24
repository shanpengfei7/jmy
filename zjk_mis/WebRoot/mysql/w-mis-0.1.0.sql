/*==============================================================*/
/* Table: can_kao                                               */
/*==============================================================*/
create table can_kao 
(
   id                   int                            not null auto_increment,
   isdelete             bool                           not null default '0',
   liang_biao_id        int                            null,
   zhi_dao_yi_jian      text                           null,
   jian_yi              text                           null,
   yao_shan             text                           null,
   constraint PK_CAN_KAO primary key clustered (id)
);

/*==============================================================*/
/* Table: ce_ping_bao_gao1                                      */
/*==============================================================*/
create table ce_ping_bao_gao1 
(
   id                   int                            not null auto_increment,
   isdelete             bool                           not null default '0',
   cishu                int                            not null,
   ji_chu_xin_xi_id     int                            not null,
   constraint PK_CE_PING_BAO_GAO1 primary key clustered (id)
);

/*==============================================================*/
/* Table: ce_ping_bao_gao10                                     */
/*==============================================================*/
create table ce_ping_bao_gao10 
(
   id                   int                            not null auto_increment,
   isdelete             bool                           not null default '0',
   cishu                int                            not null,
   ji_chu_xin_xi_id     int                            not null,
   constraint PK_CE_PING_BAO_GAO10 primary key clustered (id)
);

/*==============================================================*/
/* Table: ce_ping_bao_gao11                                     */
/*==============================================================*/
create table ce_ping_bao_gao11 
(
   id                   int                            not null auto_increment,
   isdelete             bool                           not null default '0',
   cishu                int                            not null,
   ji_chu_xin_xi_id     int                            not null,
   constraint PK_CE_PING_BAO_GAO11 primary key clustered (id)
);

/*==============================================================*/
/* Table: ce_ping_bao_gao12                                     */
/*==============================================================*/
create table ce_ping_bao_gao12 
(
   id                   int                            not null auto_increment,
   isdelete             bool                           not null default '0',
   cishu                int                            not null,
   ji_chu_xin_xi_id     int                            not null,
   constraint PK_CE_PING_BAO_GAO12 primary key clustered (id)
);

/*==============================================================*/
/* Table: ce_ping_bao_gao13                                     */
/*==============================================================*/
create table ce_ping_bao_gao13 
(
   id                   int                            not null auto_increment,
   isdelete             bool                           not null default '0',
   cishu                int                            not null,
   ji_chu_xin_xi_id     int                            not null,
   constraint PK_CE_PING_BAO_GAO13 primary key clustered (id)
);

/*==============================================================*/
/* Table: ce_ping_bao_gao2                                      */
/*==============================================================*/
create table ce_ping_bao_gao2 
(
   id                   int                            not null auto_increment,
   isdelete             bool                           not null default '0',
   cishu                int                            not null,
   ji_chu_xin_xi_id     int                            not null,
   constraint PK_CE_PING_BAO_GAO2 primary key clustered (id)
);

/*==============================================================*/
/* Table: ce_ping_bao_gao3                                      */
/*==============================================================*/
create table ce_ping_bao_gao3 
(
   id                   int                            not null auto_increment,
   isdelete             bool                           not null default '0',
   cishu                int                            not null,
   ji_chu_xin_xi_id     int                            not null,
   constraint PK_CE_PING_BAO_GAO3 primary key clustered (id)
);

/*==============================================================*/
/* Table: ce_ping_bao_gao4                                      */
/*==============================================================*/
create table ce_ping_bao_gao4 
(
   id                   int                            not null auto_increment,
   isdelete             bool                           not null default '0',
   cishu                int                            not null,
   ji_chu_xin_xi_id     int                            not null,
   constraint PK_CE_PING_BAO_GAO4 primary key clustered (id)
);

/*==============================================================*/
/* Table: ce_ping_bao_gao5                                      */
/*==============================================================*/
create table ce_ping_bao_gao5 
(
   id                   int                            not null auto_increment,
   isdelete             bool                           not null default '0',
   cishu                int                            not null,
   ji_chu_xin_xi_id     int                            not null,
   constraint PK_CE_PING_BAO_GAO5 primary key clustered (id)
);

/*==============================================================*/
/* Table: ce_ping_bao_gao6                                      */
/*==============================================================*/
create table ce_ping_bao_gao6 
(
   id                   int                            not null auto_increment,
   isdelete             bool                           not null default '0',
   cishu                int                            not null,
   ji_chu_xin_xi_id     int                            not null,
   constraint PK_CE_PING_BAO_GAO6 primary key clustered (id)
);

/*==============================================================*/
/* Table: ce_ping_bao_gao7                                      */
/*==============================================================*/
create table ce_ping_bao_gao7 
(
   id                   int                            not null auto_increment,
   isdelete             bool                           not null default '0',
   cishu                int                            not null,
   ji_chu_xin_xi_id     int                            not null,
   constraint PK_CE_PING_BAO_GAO7 primary key clustered (id)
);

/*==============================================================*/
/* Table: ce_ping_bao_gao8                                      */
/*==============================================================*/
create table ce_ping_bao_gao8 
(
   id                   int                            not null auto_increment,
   isdelete             bool                           not null default '0',
   cishu                int                            not null,
   ji_chu_xin_xi_id     int                            not null,
   constraint PK_CE_PING_BAO_GAO8 primary key clustered (id)
);

/*==============================================================*/
/* Table: ce_ping_bao_gao9                                      */
/*==============================================================*/
create table ce_ping_bao_gao9 
(
   id                   int                            not null auto_increment,
   isdelete             bool                           not null default '0',
   cishu                int                            not null,
   ji_chu_xin_xi_id     int                            not null,
   constraint PK_CE_PING_BAO_GAO9 primary key clustered (id)
);

/*==============================================================*/
/* Table: da_an                                                 */
/*==============================================================*/
create table da_an 
(
   id                   int                            not null auto_increment,
   isdelete             bool                           not null default '0',
   ti_mu                int                            not null,
   ji_chu_xin_xi_id     int                            not null,
   da_an                varchar(255)                   not null,
   liang_biao_id        int                            not null,
   ci_shu               int                            not null,
   constraint PK_DA_AN primary key clustered (id)
);

/*==============================================================*/
/* Table: deng_lu                                               */
/*==============================================================*/
create table deng_lu 
(
   id                   int                            not null auto_increment,
   isdelete             bool                           not null default '0',
   dengluhao            varchar(255)                   not null,
   mima                 varchar(255)                   not null,
   quanxian             int                            not null,
   constraint PK_DENG_LU primary key clustered (id)
);

/*==============================================================*/
/* Table: fang_an_and_tiao_jie                                  */
/*==============================================================*/
create table fang_an_and_tiao_jie 
(
   id                   int                            not null auto_increment,
   zhen_liao_fang_an_id int                            not null,
   xin_shen_tiao_jie_id int                            not null,
   constraint PK_FANG_AN_AND_TIAO_JIE primary key clustered (id)
);

/*==============================================================*/
/* Table: fang_an_and_xianng_mu                                 */
/*==============================================================*/
create table fang_an_and_xianng_mu 
(
   zhen_liao_fang_an_id int                            null,
   jian_ce_de_xiang_mu_id int                            null,
   id                   int                            not null auto_increment,
   constraint PK_FANG_AN_AND_XIANNG_MU primary key clustered (id)
);

/*==============================================================*/
/* Table: fang_an_and_yao_wu                                    */
/*==============================================================*/
create table fang_an_and_yao_wu 
(
   id                   int                            not null auto_increment,
   zhen_liao_fang_an_id int                            not null,
   yao_wu_zhi_liao_id   int                            not null,
   constraint PK_FANG_AN_AND_YAO_WU primary key clustered (id)
);

/*==============================================================*/
/* Table: fang_an_and_zhen_duan                                 */
/*==============================================================*/
create table fang_an_and_zhen_duan 
(
   id                   int                            not null auto_increment,
   zhen_liao_fang_an_id int                            not null,
   xin_shen_zhen_duan_id int                            not null,
   constraint PK_FANG_AN_AND_ZHEN_DUAN primary key clustered (id)
);

/*==============================================================*/
/* Table: fu_zhen_shi_jian                                      */
/*==============================================================*/
create table fu_zhen_shi_jian 
(
   id                   int                            not null auto_increment,
   isdelete             bool                           not null default '0',
   shijian              int                            not null,
   zhen_liao_fang_an_id int                            not null,
   constraint PK_FU_ZHEN_SHI_JIAN primary key clustered (id)
);

/*==============================================================*/
/* Table: ji_chu_and_xiang_mu                                   */
/*==============================================================*/
create table ji_chu_and_xiang_mu 
(
   id                   int                            not null auto_increment,
   jian_ce_xiang_mu_id  int                            not null,
   jian_ce_de_xiang_mu_id int                            not null,
   constraint PK_JI_CHU_AND_XIANG_MU primary key clustered (id)
);

/*==============================================================*/
/* Table: ji_chu_xin_xi                                         */
/*==============================================================*/
create table ji_chu_xin_xi 
(
   id                   int                            not null auto_increment,
   isdelete             bool                           not null default '0',
   yonghuid             varchar(255)                   not null,
   riqi                 datetime                       not null,
   menzhenhao           varchar(255)                   null,
   binganhao            varchar(255)                   null,
   zhuguanyishi         varchar(255)                   null,
   suoshukeshi          varchar(255)                   null,
   zhuankeyisheng       varchar(255)                   null,
   xingming             varchar(255)                   null,
   xingbie              int                            null,
   chushengnian         int                            null,
   chushengyue          int                            null,
   chushengri           int                            null,
   minzu                varchar(255)                   null,
   hunyinzhuangkuang    varchar(255)                   null,
   shengao              int                            null,
   tizhong              int                            null,
   chushengdi           varchar(255)                   null,
   zhiye                varchar(255)                   null,
   wenhuachengdu        varchar(255)                   null,
   paihang1             int                            null,
   paihang2             int                            null,
   jingjizhuangkuang    int                            null,
   lianxidizhi          varchar(255)                   null,
   lianxidianhua        varchar(255)                   null,
   ke_shi_id            int                            null,
   zhuankeyisheng_id    int                            null,
   yi_yuan_id           int                            null,
   constraint PK_JI_CHU_XIN_XI primary key clustered (id)
);

/*==============================================================*/
/* Table: jian_ce_de_xiang_mu                                   */
/*==============================================================*/
create table jian_ce_de_xiang_mu 
(
   id                   int                            not null auto_increment,
   isdelete             bool                           not null default '0',
   xiangmu              varchar(255)                   not null,
   isjiance             bool                           null default '0',
   constraint PK_JIAN_CE_DE_XIANG_MU primary key clustered (id)
);

/*==============================================================*/
/* Table: jian_ce_xiang_mu                                      */
/*==============================================================*/
create table jian_ce_xiang_mu 
(
   id                   int                            not null auto_increment,
   isdelete             bool                           not null default '0',
   cishu                int                            not null,
   ji_chu_xin_xi        int                            not null,
   riqi                 datetime                       not null,
   constraint PK_JIAN_CE_XIANG_MU primary key clustered (id)
);

/*==============================================================*/
/* Table: ke_shi                                                */
/*==============================================================*/
create table ke_shi 
(
   id                   int                            not null auto_increment,
   isdelete             bool                           not null default '0',
   mingcheng            varchar(255)                   not null,
   yiyuan               varchar(255)                   not null,
   yi_yuan_id           int                            not null,
   constraint PK_KE_SHI primary key clustered (id)
);

/*==============================================================*/
/* Table: liang_biao                                            */
/*==============================================================*/
create table liang_biao 
(
   id                   int                            not null auto_increment,
   isdelete             bool                           null default '0',
   mingcheng            varchar(255)                   null,
   jianjie              text                           null,
   yaoqiu               text                           null,
   shijian              varchar(255)                   null,
   zhuyishixiang        text                           null,
   yingyongpingjia      text                           null,
   constraint PK_LIANG_BIAO primary key clustered (id)
);


/*==============================================================*/
/* Table: liang_biao_and_xiang_mu                               */
/*==============================================================*/
create table liang_biao_and_xiang_mu 
(
   id                   int                            not null auto_increment,
   liang_biao_id        int                            not null,
   jian_ce_de_xiang_mu_id int                            not null,
   isceping             bool                           not null default '0',
   constraint PK_LIANG_BIAO_AND_XIANG_MU primary key clustered (id)
);

/*==============================================================*/
/* Table: shi_ti                                                */
/*==============================================================*/
create table shi_ti 
(
   id                   int                            not null auto_increment,
   isdelete             bool                           null default '0',
   liang_biao_id        int                            null,
   ti_hao               int                            null,
   ti_mu                text                           null,
   a                    varchar(255)                   null,
   b                    varchar(255)                   null,
   c                    varchar(255)                   null,
   d                    varchar(255)                   null,
   e                    varchar(255)                   null,
   f                    varchar(255)                   null,
   g                    varchar(255)                   null,
   constraint PK_SHI_TI primary key clustered (id)
);


/*==============================================================*/
/* Table: xin_shen_tiao_jie                                     */
/*==============================================================*/
create table xin_shen_tiao_jie 
(
   id                   int                            not null auto_increment,
   isdelete             bool                           not null default '0',
   xiangmu              varchar(255)                   not null,
   cishu                varchar(255)                   not null,
   constraint PK_XIN_SHEN_TIAO_JIE primary key clustered (id)
);

/*==============================================================*/
/* Table: xin_shen_zhen_duan                                    */
/*==============================================================*/
create table xin_shen_zhen_duan 
(
   id                   int                            not null auto_increment,
   isdelete             bool                           not null default '0',
   xiangmu              varchar(255)                   not null,
   constraint PK_XIN_SHEN_ZHEN_DUAN primary key clustered (id)
);

/*==============================================================*/
/* Table: yao_wu                                                */
/*==============================================================*/
create table yao_wu 
(
   id                   int                            not null auto_increment,
   isdelete             bool                           not null default '0',
   yaoming              varchar(255)                   not null,
   guige                varchar(255)                   not null,
   yongliang            varchar(255)                   not null,
   constraint PK_YAO_WU primary key clustered (id)
);

/*==============================================================*/
/* Table: yao_wu_zhi_liao                                       */
/*==============================================================*/
create table yao_wu_zhi_liao 
(
   id                   int                            not null auto_increment,
   isdelete             bool                           not null default '0',
   yaoming              varchar(255)                   not null,
   guige                varchar(255)                   not null,
   yongliang            varchar(255)                   not null,
   oneri                bool                           not null default '0',
   twori                bool                           not null default '0',
   threeri              bool                           not null default '0',
   frourri              bool                           not null default '0',
   dunfu                bool                           not null default '0',
   biyaoshi             bool                           not null default '0',
   qita                 bool                           not null default '0',
   constraint PK_YAO_WU_ZHI_LIAO primary key clustered (id)
);

/*==============================================================*/
/* Table: yi_sheng                                              */
/*==============================================================*/
create table yi_sheng 
(
   id                   int                            not null auto_increment,
   isdelete             bool                           not null,
   keshi                varchar(255)                   not null,
   yiyuan               varchar(255)                   not null,
   xingming             varchar(255)                   not null,
   xingbie              int                            not null,
   juese                varchar(255)                   not null,
   iszhuren             bool                           not null default '0',
   lianxifangshi        varchar(255)                   not null,
   ke_shi_id            int                            not null,
   deng_lu_id           int                            null,
   constraint PK_YI_SHENG primary key clustered (id)
);

/*==============================================================*/
/* Table: yi_yuan                                               */
/*==============================================================*/
create table yi_yuan 
(
   id                   int                            not null auto_increment,
   isdelete             bool                           not null,
   mingcheng            varchar(255)                   not null,
   daihao               varchar(255)                   not null,
   sheng                varchar(255)                   not null,
   shi                  varchar(255)                   not null,
   xian                 varchar(255)                   not null,
   lianxidianhua        varchar(255)                   not null,
   denglu_id            int                            not null,
   constraint PK_YI_YUAN primary key clustered (id)
);

/*==============================================================*/
/* Table: zhen_liao_fang_an                                     */
/*==============================================================*/
create table zhen_liao_fang_an 
(
   id                   int                            not null auto_increment,
   isdelete             bool                           not null default '0',
   cishu                int                            not null,
   ji_chu_xin_xi_id     int                            not null,
   riqi                 datetime                       not null,
   constraint PK_ZHEN_LIAO_FANG_AN primary key clustered (id)
);

alter table can_kao
   add constraint FK_CAN_KAO_REFERENCE_LIANG_BI foreign key (liang_biao_id)
      references liang_biao (id)
      on update cascade
      on delete cascade;

alter table ce_ping_bao_gao1
   add constraint FK_CE_PING__REFERENCE_JI_CHU_X1 foreign key (ji_chu_xin_xi_id)
      references ji_chu_xin_xi (id)
      on update cascade
      on delete cascade;

alter table ce_ping_bao_gao10
   add constraint FK_CE_PING__REFERENCE_JI_CHU_X10 foreign key (ji_chu_xin_xi_id)
      references ji_chu_xin_xi (id)
      on update cascade
      on delete cascade;

alter table ce_ping_bao_gao11
   add constraint FK_CE_PING__REFERENCE_JI_CHU_X11 foreign key (ji_chu_xin_xi_id)
      references ji_chu_xin_xi (id)
      on update cascade
      on delete cascade;

alter table ce_ping_bao_gao12
   add constraint FK_CE_PING__REFERENCE_JI_CHU_X12 foreign key (ji_chu_xin_xi_id)
      references ji_chu_xin_xi (id)
      on update cascade
      on delete cascade;

alter table ce_ping_bao_gao13
   add constraint FK_CE_PING__REFERENCE_JI_CHU_X13 foreign key (ji_chu_xin_xi_id)
      references ji_chu_xin_xi (id)
      on update cascade
      on delete cascade;

alter table ce_ping_bao_gao2
   add constraint FK_CE_PING__REFERENCE_JI_CHU_X2 foreign key (ji_chu_xin_xi_id)
      references ji_chu_xin_xi (id)
      on update cascade
      on delete cascade;

alter table ce_ping_bao_gao3
   add constraint FK_CE_PING__REFERENCE_JI_CHU_X3 foreign key (ji_chu_xin_xi_id)
      references ji_chu_xin_xi (id)
      on update cascade
      on delete cascade;

alter table ce_ping_bao_gao4
   add constraint FK_CE_PING__REFERENCE_JI_CHU_X4 foreign key (ji_chu_xin_xi_id)
      references ji_chu_xin_xi (id)
      on update cascade
      on delete cascade;

alter table ce_ping_bao_gao5
   add constraint FK_CE_PING__REFERENCE_JI_CHU_X5 foreign key (ji_chu_xin_xi_id)
      references ji_chu_xin_xi (id)
      on update cascade
      on delete cascade;

alter table ce_ping_bao_gao6
   add constraint FK_CE_PING__REFERENCE_JI_CHU_X6 foreign key (ji_chu_xin_xi_id)
      references ji_chu_xin_xi (id)
      on update cascade
      on delete cascade;

alter table ce_ping_bao_gao7
   add constraint FK_CE_PING__REFERENCE_JI_CHU_X7 foreign key (ji_chu_xin_xi_id)
      references ji_chu_xin_xi (id)
      on update cascade
      on delete cascade;

alter table ce_ping_bao_gao8
   add constraint FK_CE_PING__REFERENCE_JI_CHU_X8 foreign key (ji_chu_xin_xi_id)
      references ji_chu_xin_xi (id)
      on update cascade
      on delete cascade;

alter table ce_ping_bao_gao9
   add constraint FK_CE_PING__REFERENCE_JI_CHU_X9 foreign key (ji_chu_xin_xi_id)
      references ji_chu_xin_xi (id)
      on update cascade
      on delete cascade;

alter table da_an
   add constraint FK_DA_AN_REFERENCE_JI_CHU_X foreign key (ji_chu_xin_xi_id)
      references ji_chu_xin_xi (id)
      on update cascade
      on delete cascade;

alter table da_an
   add constraint FK_DA_AN_REFERENCE_LIANG_BI foreign key (liang_biao_id)
      references liang_biao (id)
      on update cascade
      on delete cascade;

alter table fang_an_and_tiao_jie
   add constraint FK_FANG_AN__REFERENCE_ZHEN_LIA foreign key (zhen_liao_fang_an_id)
      references zhen_liao_fang_an (id)
      on update cascade
      on delete cascade;

alter table fang_an_and_tiao_jie
   add constraint FK_FANG_AN__REFERENCE_XIN_SHEN foreign key (xin_shen_tiao_jie_id)
      references xin_shen_tiao_jie (id)
      on update cascade
      on delete cascade;

alter table fang_an_and_xianng_mu
   add constraint FK_FANG_AN__REFERENCE_ZHEN_L foreign key (zhen_liao_fang_an_id)
      references zhen_liao_fang_an (id)
      on update cascade
      on delete cascade;

alter table fang_an_and_xianng_mu
   add constraint FK_FANG_AN__REFERENCE_JIAN_CE foreign key (jian_ce_de_xiang_mu_id)
      references jian_ce_de_xiang_mu (id)
      on update cascade
      on delete cascade;

alter table fang_an_and_yao_wu
   add constraint FK_FANG_AN__REFERENCE_ZHEN foreign key (zhen_liao_fang_an_id)
      references zhen_liao_fang_an (id)
      on update cascade
      on delete cascade;

alter table fang_an_and_yao_wu
   add constraint FK_FANG_AN__REFERENCE_YAO_WU_Z foreign key (yao_wu_zhi_liao_id)
      references yao_wu_zhi_liao (id)
      on update cascade
      on delete cascade;

alter table fang_an_and_zhen_duan
   add constraint FK_FANG_AN__REFERENCE_ZHEN_LI foreign key (zhen_liao_fang_an_id)
      references zhen_liao_fang_an (id)
      on update cascade
      on delete cascade;

alter table fang_an_and_zhen_duan
   add constraint FK_FANG_AN__REFERENCE_XIN_SHE foreign key (xin_shen_zhen_duan_id)
      references xin_shen_zhen_duan (id)
      on update cascade
      on delete cascade;

alter table fu_zhen_shi_jian
   add constraint FK_FU_ZHEN__REFERENCE_ZHE foreign key (zhen_liao_fang_an_id)
      references zhen_liao_fang_an (id)
      on update cascade
      on delete cascade;

alter table ji_chu_and_xiang_mu
   add constraint FK_JI_CHU_A_REFERENCE_JIAN_CE_2 foreign key (jian_ce_xiang_mu_id)
      references jian_ce_xiang_mu (id)
      on update cascade
      on delete cascade;

alter table ji_chu_and_xiang_mu
   add constraint FK_JI_CHU_A_REFERENCE_JIAN_C foreign key (jian_ce_de_xiang_mu_id)
      references jian_ce_de_xiang_mu (id)
      on update cascade
      on delete cascade;

alter table ji_chu_xin_xi
   add constraint FK_JI_CHU_X_REFERENCE_YI_YUAN foreign key (yi_yuan_id)
      references yi_yuan (id)
      on update cascade
      on delete cascade;

alter table ji_chu_xin_xi
   add constraint FK_JI_CHU_X_REFERENCE_KE_SHI foreign key (ke_shi_id)
      references ke_shi (id)
      on update cascade
      on delete cascade;

alter table ji_chu_xin_xi
   add constraint FK_JI_CHU_X_REFERENCE_YI_SHENG foreign key (zhuankeyisheng_id)
      references yi_sheng (id)
      on update cascade
      on delete cascade;

alter table jian_ce_xiang_mu
   add constraint FK_JIAN_CE__REFERENCE_JI_CHU_X foreign key (ji_chu_xin_xi)
      references ji_chu_xin_xi (id)
      on update cascade
      on delete cascade;

alter table liang_biao_and_xiang_mu
   add constraint FK_LIANG_BI_REFERENCE_LIANG_BI foreign key (id)
      references liang_biao (id)
      on update restrict
      on delete restrict;

alter table liang_biao_and_xiang_mu
   add constraint FK_LIANG_BI_REFERENCE_JIAN_CE_ foreign key (jian_ce_de_xiang_mu_id)
      references jian_ce_de_xiang_mu (id)
      on update restrict
      on delete restrict;

alter table shi_ti
   add constraint FK_SHI_TI_REFERENCE_LIANG_BI foreign key (liang_biao_id)
      references liang_biao (id)
      on update cascade
      on delete cascade;

alter table yi_sheng
   add constraint FK_YI_SHENG_REFERENCE_DENG_LU foreign key (deng_lu_id)
      references deng_lu (id)
      on update cascade
      on delete cascade;

alter table yi_yuan
   add constraint FK_YI_YUAN_REFERENCE_DENG_LU foreign key (denglu_id)
      references deng_lu (id)
      on update cascade
      on delete cascade;

alter table zhen_liao_fang_an
   add constraint FK_ZHEN_LIA_REFERENCE_JI_CHU_X foreign key (ji_chu_xin_xi_id)
      references ji_chu_xin_xi (id)
      on update cascade
      on delete cascade;

