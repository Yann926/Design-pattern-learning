package design.simpleFactory;

public class Operation {
    private double numberFirst;
    private double numberSecond;

    public double getNumberFirst() {
        return numberFirst;
    }

    public void setNumberFirst(double numberFirst) {
        this.numberFirst = numberFirst;
    }

    public double getNumberSecond() {
        return numberSecond;
    }

    public void setNumberSecond(double numberSecond) {
        this.numberSecond = numberSecond;
    }

    public double getResult() {
        double result = 0;
        return result;
    }
}

class OperateAdd extends Operation {
    @Override
    public double getResult() {
        return getNumberFirst() + getNumberSecond();
    }
}

class OperateSub extends Operation {
    @Override
    public double getResult() {
        return getNumberFirst() - getNumberSecond();
    }
}

class OperateMul extends Operation {
    @Override
    public double getResult() {
        return getNumberFirst() * getNumberSecond();
    }
}

class OperateDiv extends Operation {
    @Override
    public double getResult() {
        return getNumberFirst() / getNumberSecond();
    }
}

class OperationSimpleFactory{
    static Operation createOperation(String operate){
        Operation operation = null;
        switch (operate){
            case "+":
                operation = new OperateAdd();
                break;
            case "-":
                operation = new OperateSub();
                break;
            case "*":
                operation = new OperateMul();
                break;
            case "/":
                operation = new OperateDiv();
                break;
            default:
                break;
        }
        return operation;
    }
}

class OperationTest{
    static void main(){
        Operation operation = OperationSimpleFactory.createOperation("+");
        operation.setNumberFirst(1.23);
        operation.setNumberSecond(4.56);
        System.out.println(operation.getResult());
    }
}