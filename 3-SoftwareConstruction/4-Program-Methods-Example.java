//Метод відправки повідомлення консультанту
public int sendMessage(EditText textField,String username, long currentTime){
        //Якщо повідомлення пусте відправляємо код помилки -1
        if (textField.getText().toString().equals("")) return -1;
        Message newMessage = new Message(username, textField.getText().toString());
        //Якщо дата невірна відправляємо код помилки -2
        if (newMessage.getMessageTime() != currentTime) return -2;
        //Працюємо з бд
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference messagesRef = rootRef.child("messages");
        messagesRef.push().setValue(
                newMessage
        );
        //Очищуємо текстове поле і повертаємо код успішного відправлення
        textField.setText("");
        return 1;
    }
