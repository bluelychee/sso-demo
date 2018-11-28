
1. 把hosts文件内容加入系统hosts，这一步的目的是能解析
www.login.com www.user.com www.order.com 三个域名到本机地址
2. 复制nginx.conf到nignx目录，并启动nginx，这一步的目的是直接访问域名就能跳转到对应的工程
3. 运行sso-login 下的 LoginApplication, sso-order 下的OrderApplication，sso-user下的UserApplication
4. 浏览器访问 www.user.com 或 www.order.com ，会跳转到 www.login.com 并自动登陆后返回www.user.com首页，显示当前的session 
