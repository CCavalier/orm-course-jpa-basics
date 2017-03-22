# Entity definition

@[Add annotation to User]({
    "stubs": ["src/main/stubs/User.java", "src/main/java/fr/fteychene/orm/jpabasics/entity/MaritalStatus.java"],
    "command": "fr.fteychene.orm.jpabasics.entity.TestEntityTopDown", 
    "project":"entity"
    })
    
@[Bottom UP]({
    "stubs": ["src/main/stubs/User.java", "src/main/java/fr/fteychene/orm/jpabasics/entity/MaritalStatus.java"],
    "command": "fr.fteychene.orm.jpabasics.entity.TestEntityBottomUp", 
    "project":"entity"
    })