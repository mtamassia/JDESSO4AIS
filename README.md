# JD Edwards AIS Single Sign On

 Proxy end-users via AIS to honor native JDE security and data access, eliminating the need to code/redefine security on the code.
 
#### Why?
 You are using a single application account with AIS but you want to utilize AIS under the context of a specific end-user without having the end-user password. You need this because you want all the end-user permissions and settings to be honored.
 
 This scenario typically occurs when developing portal/web-based integrations where you only want to retreieve the data and performs actions that the end-user actually has access to. If you don't use this approach, you will most likely need to perform security checks and data filtering on your custom code.
 

#### Software Requirements & Dependencies
 - Tools Release 9.1.4 or higher
 - JAR files needed on classpath
  - AIS_Client (obtain from JDE Update Center/Change Assistant)
  - Jackson Annotation, Core, and DataBind (these are distributed with AIS_Client)
  - JavaTokenGenerator from a E1 Web Client (obtain from webclient.ear\webclient.war\WEB-INF\lib)
  - Base_JAR from a E1 Web Client (obtain from webclient.ear\webclient.war\WEB-INF\lib)

#### JD Edwards Configuration Requirement
 - Configure your server as a trusted node as shown on [Security Administration Guide] (https://docs.oracle.com/cd/E24705_01/doc.91/e24258/setup_jde_e1_sso.htm#EOTSC00406)

