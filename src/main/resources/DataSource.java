@Bean
public DataSource DataSource {
	DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
	   dataSourceBuilder.driverClassName("org.sqlite.JDBC");
	   dataSourceBuilder.url("jdbc:sqlite:myDataBase");
	   return dataSourceBuilder.build();

}
