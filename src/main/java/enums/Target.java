package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum Target {
    LOCAL("LOCAL"),
    REMOTE("REMOTE");
    private String value;
}
