import smtplib, ssl
from email.mime.text import MIMEText
from email.mime.multipart import MIMEMultipart

class bcolors:
    HEADER = '\033[95m'
    OKBLUE = '\033[94m'
    OKCYAN = '\033[96m'
    OKGREEN = '\033[92m'
    WARNING = '\033[93m'
    FAIL = '\033[91m'
    ENDC = '\033[0m'
    BOLD = '\033[1m'
    UNDERLINE = '\033[4m'
    
smtp_server = 'smtp.gmail.com'
port = 465

sender_email = input('email:')
password = input('password:')

receiver_email = "jjc914@student.cis.edu.hk"

message = MIMEMultipart("alternative")
message["Subject"] = "multipart test"
message["From"] = sender_email
message["To"] = receiver_email

Subject = "Your mom is like living with me"
message = "text/html", "<h1>Penis</h1>"
context = ssl.create_default_context()



with smtplib.SMTP_SSL(smtp_server, port, context=context) as server:
    # server = smtplib.SMTP(smtp_server, port)
    # server.ehlo()
    # server.starttls(context=context)
    # server.ehlo()
    try:
        server.login(sender_email, password)
        print(bcolors.OKGREEN + 'Server Connected' + bcolors.ENDC)
    except: 
        print(bcolors.FAIL + "ERROR IN LOGIN" + bcolors.ENDC)
    
    try: 
        server.sendmail(sender_email, Subject, receiver_email, message)
        print(bcolors.OKCYAN + "EMAIL SENT" +bcolors.ENDC)
    
    except: 
        print(bcolors.FAIL + "EMAIL FAILED TO SEND" + bcolors.ENDC)
    response = smtp_server.mail.send.post(request_body=mail.get())
    print(bcolors.FAIL + response.status_code)
    print(bcolors.FAIL + response.body)
    print(bcolors.FAIL + response.headers)
    
    
    
    # server = smtplib.SMTP(smtp_server, port)
    # server.ehlo()
    # server.starttls(context=context)
    # server.ehlo()

# except: 
#     print(bcolors.FAIL + "ERROR IN LOGIN" + bcolors.ENDC)
#     response = sg.client.mail.send.post(request_body=mail.get())
#     print(response.status_code)
#     print(response.body)
#     print(response.headers)
#     print(bcolors.WARNING + "Please check login details or turn on less secure apps" + bcolors.ENDC)
#     print(bcolors.OKBLUE + "Or i have fuked up lmao" + bcolors.ENDC)
    