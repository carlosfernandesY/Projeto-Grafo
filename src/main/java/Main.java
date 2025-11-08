import Interface.Feed;
import Interface.Login;

void run() throws IOException, ClassNotFoundException {
    Feed feed = new Feed(new Login().telaLogin());
}
void main() throws IOException, ClassNotFoundException {
    run();
}



