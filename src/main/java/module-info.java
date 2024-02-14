module br.edu.ifba.saj.ads.poo.javafxjpa {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires jakarta.validation;
    requires transitive javafx.graphics;

    opens br.edu.ifba.saj.ads.poo.javafxjpa to javafx.base, javafx.fxml, org.hibernate.orm.core;   
    opens br.edu.ifba.saj.ads.poo.javafxjpa.model to javafx.base, javafx.fxml, org.hibernate.orm.core;   


    exports br.edu.ifba.saj.ads.poo.javafxjpa;
    exports br.edu.ifba.saj.ads.poo.javafxjpa.model;
}
