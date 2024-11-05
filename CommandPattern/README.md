## 프로젝트 설명
기존에 구현된 memento pattern에 command Pattern을 적용했다.
#### 입력 값
- 0 : 프로그램 종료 
- 1 : player walk동작 실행
- 2 : player jump동작 실행
- 3 : player run동작 실행
- 4 : player dash동작 실행
- 5 : player fly동작 실행
<br>
<br>
<br>

### class 설명 
#### o Save file
현재 레벨과 경험치를 저장하는 객체이다.

#### o SaveFiles
- careTaker 역할을 하는 일급컬렉션이다.
- 동작성 검증을 위해 SaveFilesTest에서 Juit5를 이용하여 검증하였다.

#### o PlayerController
- 사용자에게 입력받은 command를 기반으로 player의 동작을 실행한다.
- 만약 존재하지 않는 command를 입력 받는다면 "잘못된 입력입니다."를 노출한다.

### o PlayerRepository
- exit command가 실행될 때 Player의 정보를 json형태로 저장한다.
- 프로그램이 시작될 때 json 형태로 저장된 Player의 정보가 있다면 로드한다.

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
    RunCommand ..> Player : uses
    WalkCommand ..> Player : uses
    JumpCommand ..> Player : uses
    DashCommand ..> Player : uses
    FlyCommand ..> Player : uses
    ExitCommand ..> Player : uses

    Command  <|-- RunCommand
    Command  <|-- WalkCommand
    Command  <|-- JumpCommand
    Command  <|-- DashCommand
    Command  <|-- FlyCommand
    Command  <|-- ExitCommand
    
    namespace Commands-service {
        class Command{
            +execute()
        }
        
        class RunCommand {
            -Player player
            +RunCommand(Player player)
            +execute()
        }

        class WalkCommand {
            -Player player
            +WalkCommand(Player player)
            +execute()
        }

        class JumpCommand {
            -Player player
            +JumpCommand(Player player)
            +execute()
        }

        class DashCommand {
            -Player player
            +DashCommand(Player player)
            +execute()
        }

        class FlyCommand {
            -Player player
            +FlyCommand(Player player)
            +execute()
        }

        class ExitCommand {
            -Player player
            -PlayerRepository playerRepository$
            +ExitCommand(Player player)
            +execute()
            -ExitHelper$.exit(int status)
        }
 }

    namespace Originator {
    class Player {
        -String name
        -PlayerLevel playerLevel
        -Experience exp
        -SaveFiles saveFiles;
        -Player() Player
        +Player(String name) Player
        +Player(String name, int exp, List<SaveFile> saveFiles)
        +getName() String
        +printPlayerLevel() String
        +adjustExp(int exp) String
        +walk()
        +jump()
        +run()
        +dash()
        +fly()
        +save()
        +restore(SaveFile saveFile)
        +getPlayerSaveFile()
        +usePlayerSaveFile(SaveFile saveFile)
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
        +init(List<SaveFile> saveFileList)
        +createSaveFile(Player player)
        +reloadSaveFile(Player player)
        +SaveFilesSerializer$.serialize(Stack<SaveFile> saveFiles, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
    }
}


    class Experience {
        -int experience
        +Experience() Experience
        +Experience(int experience) Experience
        +setExperience(int experience) boolean
        -isValidExperience(int experience)
        -isMaxExperience() boolean
        +getExperience() int
        +copy() Experience
        +restore(Experience experience)
        +toString() String
    }

    class PlayerLevels {
        -List<PlayerLevel> levels$
        +getNextLevel(PlayerLevel nowLevel, Experience exp) PlayerLevel$
        -getNowLevelIndex(PlayerLevel nowLevel) int$
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
    }
```