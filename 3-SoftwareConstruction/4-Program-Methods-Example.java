//Метод відправки повідомлення консультанту
public int sendMessage(View view){
        EditText textField = findViewById(R.id.textField);
        //Якщо повідомлення пусте відправляємо код помилки -1
        if (textField.getText().toString().equals("")) return -1;
        //Працюємо з бд
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference messagesRef = rootRef.child("messages");
        messagesRef.push().setValue(
                new Message(FirebaseAuth.getInstance().getCurrentUser().getEmail(),
                        textField.getText().toString())
        );
        //Очищуємо текстове поле і повертаємо код успішного відправлення
        textField.setText("");
        return 1;
    }
