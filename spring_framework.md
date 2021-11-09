> low level개발 => spring framework



## framework

> 반제품, 자동화







## LoginMVC 프로젝트 바꾸기





# 환경설정

## web.xml

컨트롤러위치와 웹어플리케이션 기본 환경설정

> 위치 : src/main/webapp/WEB-INF/

```
어노테이션을 통해 controller.java로 연결할 수 있게 해주는 코드
<context:component-scan	base-package="com.myspring.pro27" />
```



## servlet-context.xml

요청처리와 아웃풋 처리하는 데 필요한 정보

> 위치 : src/main/webapp/WEB-INF/spring/appServlet/



## db.properties

데이터소스 관리

> 위치 : src/main/webapp/WEB-INF/config/jdbc/



## action-mybatis.xml

컨넥션풀-쿼리자동화-vo정보위치

> 위치 : src/main/webapp/WEB-INF/spring/

```
	<bean id="propertyPlaceholderConfigurer"
	class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
	<property name="locations">
	<value>/WEB-INF/config/jdbc/jdbc.properties</value>
	</property>
	</bean>
```



```
		<bean id="dataSource" class="org.apache.ibatis.datasource.pooled.PooledDataSource">
		<property name="driver" value="${jdbc.driverClassName}" />
		<property name="url" value="${jdbc.url}" />
		<property name="username" value="${jdbc.username}" />
		<property name="password" value="${jdbc.password}" />
		</bean>
```

```
	<bean id="sqlSessionFactory"
		class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource" />
		<property name="configLocation"
			value="classpath:mybatis/model/modelConfig.xml" />
		<property name="mapperLocations" value="classpath:mybatis/mappers/*.xml" />
	</bean>

	<bean id="sqlSession"
		class="org.mybatis.spring.SqlSessionTemplate">
		<constructor-arg index="0" ref="sqlSessionFactory"></constructor-arg>
	</bean>
```



## mapper.xml

쿼리자동화(저수준jdbc)

> 위치 : src/main/resources/mybatis/mappers/

resultMap - 데이터 list

resultType - 데이터 타입 (하나)



## modelConfig.xml

vo정보위치

> 위치 : src/main/resources/mybatis/model/







웹전체 : web.xml

DI(의존성 주입) : action-servlet.xml

DB접속 : action-mybatis.xml (config.jdbc의 jdbc.properties이용)

sql맵핑 : mybatis.mappers의 member.xml이용





# 디버깅

기본 스프링 환경에서 초기 에러 디버깅



pom.xml을 부조건 복사하지 않는다

- 기본으로 만들어진 것에 필요한 것을 한꺼번에 넣지 않고 하나씩 추가한다.
- pom.xml이 에러가 났을 경우 반드시 에러를 잡은 후에 코딩한다
  - (어노테이션이 작동 안함)



mysql의 경우 Timezone과 드라이버이름의 변경을 주의한다

- (maven에 작성) mysql 8.0.27 버전 드라이버를 추천



서비스, 컨트롤러, VO, DAO에 대한 어노테이션을 정확히 작성한다



마이바티스의 modelConfig.xml에 적용되는 VO의 패키지명을 정확히 입력한다.