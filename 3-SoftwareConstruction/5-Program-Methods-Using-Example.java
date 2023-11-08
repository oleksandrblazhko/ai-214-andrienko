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

//Метод виведення повідомлень на екран додатку користувача
private void displayAllMessages() {
        RecyclerView listOfMessages = findViewById(R.id.messagesList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setStackFromEnd(true);
        listOfMessages.setLayoutManager(layoutManager);
        //Отримуємо повідомлення з БД
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference messagesRef = rootRef.child("messages");
        //Настроювання адаптеру для взаємодії з повідомленнями
        FirebaseRecyclerOptions<Message> options = new FirebaseRecyclerOptions.Builder<Message>()
                .setQuery(messagesRef, Message.class)
                .build();
        //Створення адаптеру
        adapter = new FirebaseRecyclerAdapter<Message, MessageViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull MessageViewHolder holder, int position, @NonNull Message model) {
                holder.setMessage(model);
            }
            //Робота з обробником повідомлень
            @NonNull
            @Override
            public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
                return new MessageViewHolder(view);
            }
        };
        //Виведення повідомлень
        listOfMessages.setAdapter(adapter);
    }
