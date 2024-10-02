package models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Page implements Cloneable {
    private String pageName;
    private Page parentPage;
    private String columnNumber;
    private String displayAfter;
    private boolean publicTick;

    @Override
    public Page clone() {
        try {
            Page clone = (Page) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }
}
