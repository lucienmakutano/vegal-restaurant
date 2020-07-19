# vegal-restaurant

# set up

replace `<your-pc-user>` with the name of the name of your pc in `C:/Users/`
if your directory is not set up this way please make necessary changes

copy private `copy.properties` and rename the copy to `private.properties` next make
these configurations in `private.properties`

```xml
deploy.ant.properties.file=C:\\Users\\<your-pc-user>\\AppData\\Roaming\\NetBeans\\8.2\\config\\GlassFishEE6\\Properties\\gfv3681196611.properties
j2ee.appclient.tool.jvmoptions=-Djava.endorsed.dirs="C:\\Program Files\\glassfish-4.1.1\\glassfish\\lib\\endorsed";"C:\\Program Files\\glassfish-4.1.1\\glassfish\\modules\\endorsed" -javaagent:"C:\\Program Files\\glassfish-4.1.1\\glassfish\\lib\\gf-client.jar"=mode=acscript,arg=-configxml,arg="C:\\Users\\<your-pc-user>\\AppData\\Roaming\\NetBeans\\8.2\\config\\GF_4.1.1\\domain1\\config\\glassfish-acc.xml",client=jar=
j2ee.appclient.tool.mainclass=org.glassfish.appclient.client.AppClientFacade
j2ee.appclient.tool.runtime=
j2ee.platform.is.jsr109=true
j2ee.server.domain=C:/Users/<your-pc-user>/AppData/Roaming/NetBeans/8.2/config/GF_4.1.1/domain1
j2ee.server.home=C:/Program Files/glassfish-4.1.1/glassfish
j2ee.server.instance=[C:\\Program Files\\glassfish-4.1.1\\glassfish;C:\\Program Files\\glassfish-4.1.1\\glassfish\\domains\\domain1]deployer:gfv3ee6wc:localhost:4848
j2ee.server.middleware=C:/Program Files/glassfish-4.1.1
netbeans.user=C:\\Users\\<your-pc-user>\\AppData\\Roaming\\NetBeans\\8.2
wa.copy.client.jar.from=C:\\Users\\<your-pc-user>\\AppData\\Roaming\\NetBeans\\8.2\\config\\GF_4.1.1\\domain1\\generated\\xml
```

# usage

to run this project first deplay it by right clicking on `vegal-restaurant` then on `deploy`
next `run` the project by following the privious step but this time click on `run` instead of
`deploy`

## base url

`http://localhost:8080/vegal-restaurant-war/`