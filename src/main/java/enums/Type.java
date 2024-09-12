package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum Type {
    CHART("Chart"),
    INDICATOR("Indicator"),
    REPORT("Report"),
    HEAT_MAP("Heat");

    private String value;
}
