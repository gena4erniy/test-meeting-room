package steps;

import verification.VerifySoft;

public abstract class BaseStep {

    public void checkAll() {
        VerifySoft.showAllChecking();
    }
}
