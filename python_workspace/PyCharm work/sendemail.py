import smtplib
from email.mime.text import MIMEText
from email.header import Header
for i in range(2):
    msg = MIMEText('love','plain','utf-8')
    msg['Subject'] ="i love you"
    msg['From'] = "ld56888@163.com"
    msg['To'] = "578690904@qq.com"

    server = smtplib.SMTP("smtp.163.com",25)
    server.set_debuglevel(1)
    server.login("ld56888@163.com", "ld828521")
    server.sendmail("ld56888@163.com", ["578690904@qq.com"], msg.as_string())
    server.quit()
