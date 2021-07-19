import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Label

class CalcController implements Initializable {
    @FXML
    Label calcDispSmall
    @FXML
    Label calcDispLarge
    @FXML
    Label calcDispMem

    Calc calc

    @Override
    void initialize(URL location, ResourceBundle resources) {
        calc = new Calc(calcDispLarge, calcDispMem)
    }

    def calcBtnMCAction() {
        calc.memClear()

    }

    def calcBtnMRAction() {
        calc.memRecall()

    }

    def calcBtnMPlusAction() {
        calc.memPlus()

    }

    def calcBtnMMinusAction() {
        calc.memMinus()

    }

    def calcBtnCEAction() {
        calc.ce()

    }

    def calcBtnCAction() {
        calc.c()

    }

    def calcBtnOneOverXAction() {
        calc.oneOverX()

    }

    def calcBtnXSquaredAction() {
        calc.xSquared()

    }

    def calcBtnSquareRootAction() {
        calc.squareRoot()

    }

    def calcBtnPercentAction() {
        calc.operator("%")

    }

    def calcBtnPlusAction() {
        calc.operator("+")

    }

    def calcBtnMinusAction() {
        calc.operator("-")

    }

    def calcBtnMulAction() {
        calc.operator("*")

    }

    def calcBtnDivAction() {
        calc.operator("/")

    }

    def calcBtn0Action() {
        calc.nextInput("0")

    }

    def calcBtn1Action() {
        calc.nextInput("1")

    }

    def calcBtn2Action() {
        calc.nextInput("2")

    }

    def calcBtn3Action() {
        calc.nextInput("3")

    }

    def calcBtn4Action() {
        calc.nextInput("4")

    }

    def calcBtn5Action() {
        calc.nextInput("5")

    }

    def calcBtn6Action() {
        calc.nextInput("6")

    }

    def calcBtn7Action() {
        calc.nextInput("7")

    }

    def calcBtn8Action() {
        calc.nextInput("8")

    }

    def calcBtn9Action() {
        calc.nextInput("9")

    }

    def calcBtnSignAction() {
        calc.sign()

    }

    def calcBtnDotAction() {
        calc.nextInput(".")

    }

    def calcBtnEqAction() {
        calc.eq()

    }
}
