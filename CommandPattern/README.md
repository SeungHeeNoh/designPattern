## 프로젝트 설명
기존에 구현된 strategy pattern 프로젝트에 memento pattern을 적용했다.

### class 설명 
#### o Save file
현재 레벨과 경험치를 저장하는 객체이다.

#### o SaveFiles
- careTaker 역할을 하는 일급컬렉션이다.
- 동작성 검증을 위해 SaveFilesTest에서 Juit5를 이용하여 검증하였다.

### class diagram
```mermaid
classDiagram
    Player ..> PlayerLevels : uses
    SaveFiles o--> SaveFile : aggregation

    Player *-- Experience : exp
    Player *-- PlayerLevel : playerLevel

    SaveFile *-- Experience : exp
    SaveFile *-- PlayerLevel : playerLevel
    
    Player ..> SaveFile : dependency

    namespace Originator {
    class Player {
        -String name
        -PlayerLevel playerLevel
        -Experience exp
        +Player(String name) Player
        +getName() String
        +printPlayerLevel() String
        +adjustExp(int exp) String
        +action(int count)
        +save() SaveFile
        +restore(SaveFile saveFile)
    }
}


namespace Memento {
    class SaveFile {
        -Experience exp
        -PlayerLevel playerlevel
        +Savefile(Experience exp, PlayerLevel playerlevel)
        +equals() boolean
        +hashcode() int
        +toString() String
    }

}

namespace CareTaker {
    class SaveFiles {
        -List<SaveFile> saveFiles
        +createSaveFile(Player player)
        +reloadSaveFile(Player player)
    }
}


    class Experience {
        -int experience
        +Experience() Experience
        +Experience(experience) Experience
        +setExperience(experience) boolean
        -isValidExperience(experience)
        -isMaxExperience() boolean
        +getExperience() int
        +copy() Experience
        +restore(Experience experience)
        +toString() String
    }

    class PlayerLevels {
        -List<PlayerLevel> levels$
        +getNextLevel(nowLevel, exp) PlayerLevel$
        -getNowLevelIndex(nowLevel) int$
        -getFirstLevel() PlayerLevel$
        -getMaxExperence() int$
    }

    class PlayerLevel {
        <<abstract>>
        +getMinExp()*
        +getMaxExp()*
        +walk()*
        +jump()*
        +run()*
        +dash()
        +fly()
        +action(count)
    }
```