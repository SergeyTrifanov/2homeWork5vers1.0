package ru.skypro;

public class Main {

    public static void main(String[] args) {
        System.out.println(loginCheck(
                "Sergey",
                "Sergey2208pppppppppppp",
                "Sergey2208pppppppppppp"));

    }
    public static boolean loginCheck (String login, String password, String confirmPassword){
      boolean isPasswordCorrect;
      boolean isLoginCorrect;

      try {
          isPasswordCorrect = passwordCheck(password, confirmPassword);
          isLoginCorrect = nameCheck(login);
      } catch (WrongLoginException | WrongPasswordException e) {
          throw new RuntimeException(e);
      }
      return isPasswordCorrect & isLoginCorrect;
    }
    public static boolean nameCheck(String login){
        if (login.length() > 20){
            throw new WrongLoginException("имя пользователя превышает 20 символов");
        }
        return isStringContainsRightSymbols(login);
    }

    public static boolean passwordCheck(String password, String confirmPassword){
        if(!password.equals(confirmPassword)){
            throw new WrongPasswordException("поля пароль и подтверждения пароля должны совпадать");
    }
        if (password.length()>=20){
            throw new WrongPasswordException("пароль превышает 20 символов");
    }
        return isStringContainsRightSymbols(password);
    }
    public static boolean isStringContainsRightSymbols(String s){

        boolean correct = true;
        for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        if (!(ch>='a' && ch <= 'z' || ch>= 'A' && ch <='Z'|| ch>= '0' && ch<= '9'|| ch == '_')){
            correct = false;
            break;
        }
        }
        return correct;
    }


}
