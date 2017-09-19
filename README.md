# niuka

1.修改zk的地址
niuka_common 模块下deploy／dev/ 下面的service.properites 

#Zookeeper\u96C6\u7FA4\u5730\u5740
zookeeper.address=localhost:2181
修改zk的IP地址

2.修改数据的地址
在niuka_customer_provider，niuka_user_provider deploy／dev/  下面的
jdbc.properites 
sys.url = jdbc:mysql://192.168.1.241:3307/o2o?characterEncoding=utf8
sys.username = root
sys.password = 111111
 
 修改对应的数据库地址
