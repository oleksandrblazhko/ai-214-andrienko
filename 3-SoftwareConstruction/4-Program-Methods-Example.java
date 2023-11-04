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

//Метод запуску додатку, що описує взаємодію користувача з додатком
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityMain = findViewById(R.id.activity_main);
        //Створення кнопки для відправлення повідомлення
        sendButton = findViewById(R.id.btnSend);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //Обробка помилки
                if(sendMessage(view) == -1)
                    System.out.println("Message ERROR");
            }
        });
        //Робота за базою даних стосовно користувача
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser == null) {
            startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().build(), SIGN_IN_CODE);
        } else {
            Snackbar.make(activityMain, "Вас було авторизовано", Snackbar.LENGTH_SHORT).show();
            displayAllMessages();

            DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("users").child(currentUser.getUid());
            userRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        User user = dataSnapshot.getValue(User.class);
                        if (user != null) {
                            String userLogin = user.login;
                            String userEmail = user.email;
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    System.out.println("DATABASE ERROR");
                }
            });
        }
    }
