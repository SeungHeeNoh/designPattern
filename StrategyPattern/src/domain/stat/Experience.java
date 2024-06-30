package domain.stat;

import domain.stat.level.PlayerLevels;

public class Experience {
    private int experience = 0;

    public Experience() {
    }

    public Experience(int experience) {
        this.experience  = experience;
    }

    public boolean setExperience(int experience) {
        isValidExperience(experience);

        if (isMaxExperience()) {
            System.out.println("Player의 경험치가 MAX값이므로 적용할 수 없습니다.");
            return false;
        } else {
            this.experience += experience;

            if(isMaxExperience()) {
                this.experience = PlayerLevels.getMaxExperence();
            }
        }
        System.out.println("현재 경험치 : " + this.experience);
        return true;
    }

    private void isValidExperience(int experience) {
        if(experience < 0) {
            throw new IllegalArgumentException("experience must be greater than or equal to 0");
        }
    }

    private boolean isMaxExperience() {
        return this.experience >= PlayerLevels.getMaxExperence();
    }

    public int getExperience() {
        return this.experience;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "experience=" + experience +
                '}';
    }
}
