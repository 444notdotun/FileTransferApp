from django.core.mail import send_mail

import notification
from notification.models import Notification


def create_notification(user):
    Notification.objects.create(user=user,
                                       message = f"""Hi {user.first_name}Welcome to getpaid!/n your Wallet number is{user.wallet.wallet_number}"
                                        
                                               """ )
    send_mail(
        subject="Welcome to getpaid",
        message=notification.message,
        from_email='',
        recipient_list=[user.email],
        fail_silently=False,
    )

    notification.is_read = True

