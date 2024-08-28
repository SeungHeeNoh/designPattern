package domain.save;

import domain.stat.Experience;
import domain.stat.level.PlayerLevel;

public record SaveFile(Experience exp, PlayerLevel playerLevel) {
}
