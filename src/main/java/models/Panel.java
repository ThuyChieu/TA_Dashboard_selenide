package models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Panel {
    private String displayName;
    private String series;

    @Override
    public Panel clone() {
        try {
            Panel clone = (Panel) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }
}
