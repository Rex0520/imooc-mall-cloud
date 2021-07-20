CREATE TABLE `imooc_mall_advertisement` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '广告名称',
  `image` varchar(100) NOT NULL COMMENT '广告图片',
  `detail` varchar(100) NOT NULL COMMENT '广告详情',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='广告表';

INSERT INTO imooc_mall.imooc_mall_advertisement (name,image,detail,create_time,update_time) VALUES 
('毛豆','http://127.0.0.1:8083/category-product/images/3119b266-5ab8-4eac-80b6-f8902c91d7af.jpg','新鲜特价','2020-08-18 10:09:32','2020-08-18 10:09:32')
,('土豆处理','http://127.0.0.1:8083/category-product/images/3119b266-5ab8-4eac-80b6-f8902c91d7af.jpg','特价处理土豆','2020-08-18 10:10:23','2020-08-18 10:10:23')
,('西红柿优惠','http://127.0.0.1:8083/advertisement/images/87316a38-c479-460c-9b65-8c1a5b9c539d.jpg','早市8：00-9：30,西红柿￥1.99/kg','2020-08-18 14:18:33','2020-08-18 14:18:33')
,('嘎啦苹果','http://127.0.0.1:8083/advertisement/images/87316a38-c479-460c-9b65-8c1a5b9c539d.jpg','新上市，又脆又甜','2020-08-18 14:51:09','2020-08-18 14:51:09')
,('金针菇','http://127.0.0.1:8083/advertisement/images/87316a38-c479-460c-9b65-8c1a5b9c539d.jpg','绿色蔬菜','2020-08-18 14:51:50','2020-08-18 14:51:50')
;