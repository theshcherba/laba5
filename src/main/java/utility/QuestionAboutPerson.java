package utility;

import classesandenums.*;
import exceptions.IncorrectInputInScriptException;
import exceptions.MustBeNotEmptyException;
import exceptions.NotInDeclaredLimitsException;
import progastart.Proga;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class QuestionAboutPerson {
    private final double MAX_X = 935;
    private final double MIN_HEIGHT = 0;
    private final double MIN_Y = -815;

    private Scanner userScanner;
    private boolean fileMode;

    public QuestionAboutPerson(Scanner userScanner) {
        this.userScanner = userScanner;
        fileMode = false;
    }
    /**
     * @return Scanner, which uses for user input.
     */
    public Scanner getUserScanner() {
        return userScanner;
    }

    /**
     * Sets marine asker mode to 'File Mode'.
     */
    public void setFileMode() {
        fileMode = true;
    }

    /**
     * Sets marine asker mode to 'User Mode'.
     */
    public void setUserMode() {
        fileMode = false;
    }
    public String askName() throws IncorrectInputInScriptException {
        String name;
        while (true) {
            try {
                Console.println("Введите имя:");
                Console.print(Proga.PS2);
                name = userScanner.nextLine().trim();
                if (fileMode) Console.println(name);
                if (name.equals("")) throw new MustBeNotEmptyException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Имя не распознано!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (MustBeNotEmptyException exception) {
                Console.printerror("Имя не может быть пустым!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return name;
    }
    public double askCX() throws IncorrectInputInScriptException {
        String strX;
        double x;
        while (true) {
            try {
                Console.println("Введите координату X < " + (MAX_X+1) + ":");
                Console.print(Proga.PS2);
                strX = userScanner.nextLine().trim();
                if (fileMode) Console.println(strX);
                x = Double.parseDouble(strX);
                break;
                if (x > MAX_X) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Координата X не распознана!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                Console.printerror("Координата X не может превышать " + MAX_X + "!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Координата X должна быть представлена числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return x;
    }
    public long askCY() throws IncorrectInputInScriptException {
        String strY;
        long y;
        while (true) {
            try {
                Console.println("Введите координату Y > " + (MIN_Y - 1) + ":");
                Console.print(Proga.PS2);
                strY = userScanner.nextLine().trim();
                if (fileMode) Console.println(strY);
                y = Long.parseLong(strY);
                if (y < MIN_Y) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Координата Y не распознана!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                Console.printerror("Координата Y не может быть меньше " + MIN_Y + "!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Координата Y должна быть представлена числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return y;
    }
        public Coordinates askCoordinates() throws IncorrectInputInScriptException {
            double x;
            long y;
            x = askCX();
            y = askCY();
            return new Coordinates(x, y);
        }

    public Double askLX() throws IncorrectInputInScriptException {
        String strX;
        Double x;
        while (true) {
            try {
                Console.println("Введите координату X:");
                Console.print(Proga.PS2);
                strX = userScanner.nextLine().trim();
                if (fileMode) Console.println(strX);
                x = Double.parseDouble(strX);
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Координата X не распознана!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Координата X должна быть представлена числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return x;
    }

    /**
     * Asks a user the marine's Y coordinate.
     * @return Marine's Y coordinate.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public double askLY() throws IncorrectInputInScriptException {
        String strY;
        double y;
        while (true) {
            try {
                Console.println("Введите координату Y:");
                Console.print(Proga.PS2);
                strY = userScanner.nextLine().trim();
                if (fileMode) Console.println(strY);
                y = Double.parseDouble(strY);
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Координата Y не распознана!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Координата Y должна быть представлена числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return y;
    }

    public Long askLZ() throws IncorrectInputInScriptException {
        String strZ;
        Long z;
        while (true) {
            try {
                Console.println("Введите координату Z:");
                Console.print(Proga.PS2);
                strZ = userScanner.nextLine().trim();
                if (fileMode) Console.println(strZ);
                z = Long.parseLong(strZ);
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Координата Z не распознана!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Координата Z должна быть представлена числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return z;
    }

    public String askLocationName() throws IncorrectInputInScriptException {
        String locationName;
        while (true) {
            try {
                Console.println("Введите название города:");
                Console.print(Proga.PS2);
                locationName = userScanner.nextLine().trim();
                if (fileMode) Console.println(locationName);
                if (locationName.equals("")) throw new MustBeNotEmptyException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Название города не распознано!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (MustBeNotEmptyException exception) {
                Console.printerror("Название города не может быть пустым!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return locationName;
    }
    public Location askLocation() throws IncorrectInputInScriptException {
        Double x;
        double y;
        Long z;
        String name;
        x = askLX();
        y = askLY();
        z = askLZ();
        name = askLocationName();
        return new Location(x, y, z, name);
    }

    public int askHeight() throws IncorrectInputInScriptException {
        String strHeight;
        int height;
        while (true) {
            try {
                Console.println("Введите здоровье:");
                Console.print(Proga.PS2);
                strHeight = userScanner.nextLine().trim();
                if (fileMode) Console.println(strHeight);
                height = Integer.parseInt(strHeight);
                if (height < MIN_HEIGHT) throw new NotInDeclaredLimitsException();
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Рост не распознан!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInDeclaredLimitsException exception) {
                Console.printerror("Рост должен быть больше нуля!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                Console.printerror("Здоровье должно быть представлено числом!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return height;
    }

    public HColor askHairColour() throws IncorrectInputInScriptException {
        String strHairColor;
        HColor hairColor;
        while (true) {
            try {
                Console.println("Список цвета волос- " + HColor.nameList());
                Console.println("Введите цвет волос:");
                Console.print(Proga.PS2);
                strHairColor = userScanner.nextLine().trim();
                if (fileMode) Console.println(strHairColor);
                hairColor = HColor.valueOf(strHairColor.toUpperCase());
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Цвет волос не распознан!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalArgumentException exception) {
                Console.printerror("Такого цвета волос нет в списке!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return hairColor;
    }
    public EColor askEyeColour() throws IncorrectInputInScriptException {
        String strEyeColor;
        EColor eyeColor;
        while (true) {
            try {
                Console.println("Список цвета глаз- " + EColor.nameList());
                Console.println("Введите цвет глаз:");
                Console.print(Proga.PS2);
                strEyeColor = userScanner.nextLine().trim();
                if (fileMode) Console.println(strEyeColor);
                eyeColor = EColor.valueOf(strEyeColor.toUpperCase());
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Цвет глаз не распознан!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalArgumentException exception) {
                Console.printerror("Такого цвета глаз нет в списке!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return eyeColor;
    }
    public Country askNationality() throws IncorrectInputInScriptException {
        String strNationality;
        Country nationality;
        while (true) {
            try {
                Console.println("Список стран- " + Country.nameList());
                Console.println("Введите страну:");
                Console.print(Proga.PS2);
                strNationality = userScanner.nextLine().trim();
                if (fileMode) Console.println(strNationality);
                nationality = Country.valueOf(strNationality.toUpperCase());
                break;
            } catch (NoSuchElementException exception) {
                Console.printerror("Стана не распознана!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalArgumentException exception) {
                Console.printerror("Такой страны нет в списке!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                Console.printerror("Непредвиденная ошибка!");
                System.exit(0);
            }
        }
        return nationality;
    }

        public String toString() {
            return "QuestionAboutPerson (вспомогательный класс для запросов пользователю)";
        }
    }
}
