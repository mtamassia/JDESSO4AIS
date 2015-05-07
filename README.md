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

#### JD Edwards SSO Configuration Requirement
 You will need to add a new node, define the token lifetime, and set it up as a trusted node to your existing enterprise server (security server). All high-level steps are shown on the  [Security Administration Guide] (https://docs.oracle.com/cd/E24705_01/doc.91/e24258/setup_jde_e1_sso.htm#EOTSC00406) but are detailed below.
 
 1) Verify your existing Enterprise server is already a node. If not add it
 
 2) Add a new Node. In our case we are using the generic name SSO4AIS as show below. The password will need to match the password used inside the TokenGen.ini (which must be on classpath)
 ![Node](https://cloud.githubusercontent.com/assets/3932010/7525852/ea0d00ca-f4da-11e4-956b-22a9105e9762.png)
 
 3) Setup the Token Lifetime for the new node as show below
 ![Node](https://cloud.githubusercontent.com/assets/3932010/7525893/2f7bbd0e-f4db-11e4-913e-6ce2d37fb406.png)
 
 4) Setup the new node as a Trusted Node to your enterprise server
 
 5) Restart enterprise server
 

