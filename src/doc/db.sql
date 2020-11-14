
create table brms_rule_set
(
   id                   bigint unsigned not null auto_increment comment 'id自增1',
   rule_set_key         varchar(50) not null comment '规则集key(package)',
   rule_set_name        varchar(200) not null default '' comment '规则集名称',
   is_delete            tinyint not null default 0 comment '是否删除',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   primary key (id),
   unique key uk_rule_set_key (rule_set_key)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='规则集表';



create table brms_rule_set_model
(
   id                   bigint unsigned not null auto_increment comment 'id自增1',
   model_key            varchar(50) not null comment '模型key',
   rule_set_key         varchar(50) not null comment '规则集key(package)',
   is_delete            tinyint not null default 0 comment '是否删除',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   primary key (id)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='规则模型关联表';


create table brms_model
(
   id                   bigint unsigned not null auto_increment comment 'id自增1',
   model_key            varchar(50) not null comment '模型key',
   model_desc           varchar(200) not null default '' comment '模型描述',
   is_delete            tinyint not null default 0 comment '是否删除',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   primary key (id),
   unique key uk_model_key (model_key)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='模型表';



create table brms_rule
(
   id                   bigint unsigned not null auto_increment comment 'id自增1',
   rule_key             varchar(50) not null comment '规则key',
   rule_desc            varchar(200) not null default '' comment '规则描述',
   rule_set_key         varchar(50) not null comment '规则集key(package)',
   activation_group     varchar(50) not null default '' comment 'activation-group',
   agenda_group         varchar(50) not null default '' comment 'agenda-group',
   no_loop              varchar(5) not null default '' comment 'no-loop(false 或 true)',
   date_effective       varchar(20) not null default '' comment 'date-effective(格式yyyy-MM-DD HH:mm:ss)',
   date_expires         varchar(20) not null default '' comment 'date-expires(格式yyyy-MM-DD HH:mm:ss)',
   salience             int unsigned comment 'salience(优先级,值越大优先级越高)',
   is_delete            tinyint not null default 0 comment '是否删除',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   primary key (id),
   unique key uk_rule_key (rule_key)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='规则表';


create table brms_model_attr
(
   id                   bigint unsigned not null auto_increment comment 'id自增1',
   model_key            varchar(50) not null comment '模型key',
   attr_name            varchar(50) not null comment '属性名称',
   attr_desc            varchar(200) not null default '' comment '属性描述',
   attr_type            varchar(20) not null comment '属性类型(STRING,NUMBER,BOOLEAN,DATE,COLLECTION)',
   attr_value_source    varchar(20) comment '属性值来源(INPUT,DICT,ADDRESS)',
   is_delete            tinyint not null default 0 comment '是否删除',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   primary key (id),
   unique key uk_model_key_attr_name (model_key, attr_name)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='模型属性表';


create table brms_rule_condition
(
   id                   bigint unsigned not null auto_increment comment 'id自增1',
   rule_key             varchar(50) not null comment '规则key',
   attr_name            varchar(50) not null comment '属性名称',
   condition_operator   varchar(50) not null comment '条件符',
   condition_value      varchar(1000) not null comment '条件值',
   logical_operator     varchar(2) not null default '' comment '逻辑运算符(与下一个条件的逻辑运算符;取值: &&,|| )',
   condition_order      int not null default 0 comment '排序(多个条件通过order排序,值越小越靠前,并通过 logical_operator 字段进行连接)',
   is_delete            tinyint unsigned not null default 0 comment '是否删除',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   primary key (id),
   index idx_rule_key(rule_key(20))
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='规则条件表(LHS)';


create table brms_rule_action
(
   id                   bigint unsigned not null auto_increment comment 'id自增1',
   rule_key             varchar(50) not null comment '规则key',
   model_key            varchar(50) not null comment '模型key',
   attr_name            varchar(50) not null comment '属性名称',
   action_value         varchar(1000) not null comment '动作值',
   is_delete            tinyint not null default 0 comment '是否删除',
   create_time          timestamp not null default CURRENT_TIMESTAMP comment '创建时间',
   update_time          timestamp not null default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
   primary key (id),
   index idx_rule_key(rule_key(20))
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='规则动作表(RHS)';



