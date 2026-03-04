from wallet.service import create_wallet
from user.services import create_user
from django.db import transaction
from notification.service import create_notification


@transaction.atomic
def create_user_and_wallet(validated_data):
    user = create_user(validated_data)
    wallet = create_wallet(user)
    return user, wallet