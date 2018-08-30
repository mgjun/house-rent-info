FROM tomcat:8

ADD tomcat-users.xml /usr/local/tomcat/conf/

RUN rm -rf /usr/local/tomcat/webapps/houseRent

CMD ["catalina.sh", "run"]