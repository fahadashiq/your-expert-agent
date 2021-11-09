package com.hsrw.yea;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.hsrw.yea");

        noClasses()
            .that()
            .resideInAnyPackage("com.hsrw.yea.service..")
            .or()
            .resideInAnyPackage("com.hsrw.yea.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..com.hsrw.yea.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
